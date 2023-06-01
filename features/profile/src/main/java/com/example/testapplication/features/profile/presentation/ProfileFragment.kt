package com.example.testapplication.features.profile.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.features.profile.databinding.FragmentProfileBinding
import com.example.testapplication.core.presentation.viewmodel.ViewModelFactory
import com.example.testapplication.features.profile.di.component.ProfileComponentDependencies
import com.example.testapplication.features.profile.di.component.ProfileComponentDependenciesProvider
import com.example.testapplication.features.profile.di.component.ProfileComponentViewModel
import javax.inject.Inject

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private var pickedImageAvatar: Uri? = null

    private val pickImageFromGalleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK)
                pickedImageAvatar = it.data?.data
        }

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ProfileViewModel

    override fun onAttach(context: Context) {
        val dependencies: ProfileComponentDependencies =
            (context.applicationContext as ProfileComponentDependenciesProvider).getProfileComponentDependencies()
        ViewModelProvider(this)[ProfileComponentViewModel::class.java]
            .newProfileComponent(dependencies)
            .injectProfileFragment(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[ProfileViewModel::class.java]
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.buttonLogOut.setOnClickListener {
            viewModel.startAuthenticationScreen(requireContext())
        }

        binding.shapeableImageViewAvatarProfile.setOnClickListener {
            pickImageFromGalleryLauncher.launch(
                Intent(Intent.ACTION_PICK).setDataAndType(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MEDIA_TYPE
                )
            )
            //to save selected profile photo implement image saving in the local/remote datasource
        }
    }

    override fun onResume() {
        binding.shapeableImageViewAvatarProfile.setImageURI(pickedImageAvatar)
        super.onResume()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val MEDIA_TYPE = "image/*"
    }
}
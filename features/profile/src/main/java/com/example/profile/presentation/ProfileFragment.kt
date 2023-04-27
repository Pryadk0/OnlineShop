package com.example.profile.presentation

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
import com.example.presentation.ViewModelFactory
import com.example.profile.databinding.FragmentProfileBinding
import javax.inject.Inject


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding: FragmentProfileBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    // need subComponent for Module!
    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }


    private var pickedImageAvatar: Uri? = null

    private val pickImageFromGalleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK)
                pickedImageAvatar = it.data?.data
        }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: ProfileViewModel
    private val component by lazy {

    }

    override fun onAttach(context: Context) {
        val profileComponent =
        component.inject(this)
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
        binding.buttonLogOut.setOnClickListener {
            viewModel.startAuthenticationScreen(requireContext())
        }

        binding.shapeableImageViewAvatarProfile.setOnClickListener {
            pickImageFromGalleryLauncher.launch(
                Intent(Intent.ACTION_PICK).setDataAndType(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*"
                )
            )
            //to save profile photo changes implement selected photo saving in the local/remote datasource
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
}
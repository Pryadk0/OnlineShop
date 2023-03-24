package com.example.testapplication.presentation.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.testapplication.databinding.FragmentProfileBinding
import com.example.testapplication.presentation.activities.AuthenticationActivity


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogOut.setOnClickListener {
            startActivity(Intent(context, AuthenticationActivity::class.java))
        }

        binding.shapeableImageViewAvatarProfile.setOnClickListener {
            pickImageFromGalleryLauncher.launch(
                Intent(Intent.ACTION_PICK).setDataAndType(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*"
                )
            )
            //to save profile photo changes implement selected photo save in the local/remote datasource
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
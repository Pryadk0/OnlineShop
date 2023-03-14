package com.example.testapplication.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testapplication.R
import com.example.testapplication.databinding.FragmentSignInPageBinding
import com.example.testapplication.domain.User
import com.example.testapplication.presentation.TestApplication
import com.example.testapplication.presentation.fragments.utils.EmptyEditTextHandler
import com.example.testapplication.presentation.viewmodels.AuthenticationViewModel
import com.example.testapplication.presentation.viewmodels.ViewModelFactory
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject


class SignInPageFragment : Fragment() {
    private var _binding: FragmentSignInPageBinding? = null
    private val binding: FragmentSignInPageBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    private val component by lazy {
        (requireActivity().application as TestApplication).component
    }
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this, viewModelFactory)[AuthenticationViewModel::class.java]
        binding.textViewLogIn.setOnClickListener {
            findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToLogInFragment())
        }

        binding.buttonSignIn.setOnClickListener {
            if (EmptyEditTextHandler.handleEmptyText(
                    binding.editTextFirstNameFragmentSignIn,
                    binding.textViewFirstNameFragmentSignInPageError
                )
                and EmptyEditTextHandler.handleEmptyText(
                    binding.editTextLastName,
                    binding.textViewLastNameError
                )
                and handleInvalidEmail(binding.editTextEmail, binding.textViewEmailError)
            ) {
                val userFromDb: User? =
                    viewModel.getUserFormDb(binding.editTextFirstNameFragmentSignIn.text.toString())
                userFromDb?.let {
                    Toast.makeText(
                        context,
                        String.format(
                            getString(R.string.toast_user_is_already_exists),
                            userFromDb.firstName
                        ),
                        Toast.LENGTH_SHORT
                    ).show()
                } ?: run {
                    viewModel.writeUserInDb(
                        binding.editTextFirstNameFragmentSignIn.text.toString(),
                        binding.editTextLastName.text.toString(),
                        binding.editTextEmail.text.toString()
                    )
                    findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())
                }
            }
        }

        binding.textViewSignInWithGoogle.setOnClickListener {
            findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())
        }
        binding.imageViewGoogleIcon.setOnClickListener {
            findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())
        }
        binding.textViewSignInWithApple.setOnClickListener {
            findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())
        }
        binding.imageViewAppleIcon.setOnClickListener {
            findNavController().navigate(SignInPageFragmentDirections.actionSignInPageFragmentToAuthorizedActivity())
        }


    }

    private fun handleInvalidEmail(
        editTextPassword: TextInputEditText,
        textViewError: TextView
    ): Boolean {
        if (!TextUtils.isEmpty(editTextPassword.text) && Patterns.EMAIL_ADDRESS.matcher(
                editTextPassword.text.toString()
            ).matches()
        ) {
            if (textViewError.visibility == View.VISIBLE)
                textViewError.visibility = View.GONE
            return true
        }
        textViewError.visibility = View.VISIBLE
        return false
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
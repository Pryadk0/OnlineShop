package com.example.authentication.presentation.signin

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
import com.example.authentication.R
import com.example.authentication.databinding.FragmentSignInPageBinding
import com.example.authentication.domain.entities.User
import com.example.presentation.ViewModelFactory
import com.example.presentation.handleEmptyText
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject


class SignInPageFragment : Fragment(R.layout.fragment_sign_in_page) {
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

        val viewModel = ViewModelProvider(this, viewModelFactory)[SignInPageViewModel::class.java]
        binding.textViewLogIn.setOnClickListener {
            viewModel.startSignInScreen(this)
        }

        binding.buttonSignIn.setOnClickListener {
            if (handleEmptyText(
                    binding.editTextFirstNameFragmentSignIn,
                    binding.textViewFirstNameFragmentSignInPageError
                )
                and handleEmptyText(
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
                            getString(com.example.theme.R.string.toast_user_is_already_exists),
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
                    viewModel.startAuthorizedScreen(this)
                }
            }
        }

        binding.textViewSignInWithGoogle.setOnClickListener {
            viewModel.startAuthorizedScreen(this)
        }
        binding.imageViewGoogleIcon.setOnClickListener {
            viewModel.startAuthorizedScreen(this)
        }
        binding.textViewSignInWithApple.setOnClickListener {
            viewModel.startAuthorizedScreen(this)
        }
        binding.imageViewAppleIcon.setOnClickListener {
            viewModel.startAuthorizedScreen(this)
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
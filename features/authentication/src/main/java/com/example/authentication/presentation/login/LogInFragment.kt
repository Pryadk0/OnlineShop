package com.example.authentication.presentation.login

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.authentication.R
import com.example.authentication.databinding.FragmentLogInBinding
import com.example.presentation.ViewModelFactory
import com.example.presentation.handleEmptyText
import javax.inject.Inject


class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private var _binding: FragmentLogInBinding? = null
    private val binding: FragmentLogInBinding
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
        _binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPasswordSymbolsVisibility()
        val viewModel = ViewModelProvider(this, viewModelFactory)[LogInViewModel::class.java]

        binding.buttonLogIn.setOnClickListener {
            if (
                handleEmptyText(
                    binding.editTextFirstNameFragmentLogin,
                    binding.textViewFirstNameFragmentLogInError
                )
                and handleEmptyText(
                    binding.editTextPassword,
                    binding.textViewPasswordError
                )
            ) {
               val userFromDb = viewModel.getUserFormDb(binding.editTextFirstNameFragmentLogin.text.toString())
                userFromDb?.let {
                    viewModel.startAuthorizedScreen(this)
                } ?: run {
                    Toast.makeText(context, "User ${binding.editTextPassword.text} is not exists", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun setPasswordSymbolsVisibility() {
        binding.editTextPassword.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        binding.imageViewPasswordVisibility.setOnClickListener {
            if (binding.editTextPassword.inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                binding.editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.editTextPassword.setSelection(binding.editTextPassword.length())
                (it as ImageView).setImageDrawable(
                    getDrawable(it.context, com.example.theme.R.drawable.ic_password_visibility_off)
                )
            } else {
                binding.editTextPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.editTextPassword.setSelection(binding.editTextPassword.length())
                (it as ImageView).setImageDrawable(
                    getDrawable(it.context, com.example.theme.R.drawable.ic_password_visibility_on)
                )
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
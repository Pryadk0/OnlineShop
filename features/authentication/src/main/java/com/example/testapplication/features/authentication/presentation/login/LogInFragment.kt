package com.example.testapplication.features.authentication.presentation.login

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
import com.example.features.authentication.R
import com.example.features.authentication.databinding.FragmentLogInBinding
import com.example.testapplication.core.presentation.handleEmptyText
import com.example.testapplication.core.presentation.viewmodel.ViewModelFactory
import com.example.testapplication.features.authentication.di.component.AuthenticationComponentDependencies
import com.example.testapplication.features.authentication.di.component.AuthenticationComponentDependenciesProvider
import com.example.testapplication.features.authentication.di.component.LogInComponentViewModel
import javax.inject.Inject


internal class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private var _binding: FragmentLogInBinding? = null
    private val binding: FragmentLogInBinding
        get() = _binding ?: throw RuntimeException("${this.javaClass.simpleName}Binding == null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: LogInViewModel

    override fun onAttach(context: Context) {
        val componentDependencies: AuthenticationComponentDependencies =
            (context.applicationContext as AuthenticationComponentDependenciesProvider)
                .getAuthenticationComponentDependencies()
        ViewModelProvider(this)[LogInComponentViewModel::class.java]
            .newAuthenticationComponent(componentDependencies)
            .injectLogInFragment(this)
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

        viewModel = ViewModelProvider(this, viewModelFactory)[LogInViewModel::class.java]
        setPasswordSymbolsVisibility()
        setOnCLickListeners()
    }

    private fun setPasswordSymbolsVisibility() {
        binding.editTextPassword.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        binding.imageViewPasswordVisibility.setOnClickListener {
            if (binding.editTextPassword.inputType == InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                binding.editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.editTextPassword.setSelection(binding.editTextPassword.length())
                (it as ImageView).setImageDrawable(
                    getDrawable(it.context, com.example.core.theme.R.drawable.ic_password_visibility_off)
                )
            } else {
                binding.editTextPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.editTextPassword.setSelection(binding.editTextPassword.length())
                (it as ImageView).setImageDrawable(
                    getDrawable(it.context, com.example.core.theme.R.drawable.ic_password_visibility_on)
                )
            }
        }
    }

    private fun setOnCLickListeners(){
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
                val userFromDb =
                    viewModel.getUserFormDb(binding.editTextFirstNameFragmentLogin.text.toString())
                userFromDb?.let {
                    viewModel.startAuthorizedScreen(this)
                } ?: run {
                    Toast.makeText(
                        context,
                        "User ${binding.editTextPassword.text} is not exists",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
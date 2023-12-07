package com.example.test_github

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

// MainFragment.kt
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        view.findViewById<Button>(R.id.buttonNavigate).setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_recyclerViewFragment)
        }
        val buttonLogout = view.findViewById<Button>(R.id.buttonLogout)
        buttonLogout.setOnClickListener {
            logout()
        }




        return view
    }

    private fun logout() {
        // Supprimer les informations d'identification de SharedPreferences
        val sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("username")
        editor.remove("password")
        editor.apply()

        // Naviguer vers l'écran de connexion après la déconnexion
        findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
    }
}
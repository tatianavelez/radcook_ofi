package com.example.radcooksplash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_profile, container, false)

        val imageViewProfile = rootView.findViewById<ImageView>(R.id.imageViewProfile)
        val buttonChangeProfilePicture = rootView.findViewById<Button>(R.id.buttonChangeProfilePicture)
        val editTextName = rootView.findViewById<EditText>(R.id.editTextName)
        val editTextEmail = rootView.findViewById<EditText>(R.id.editTextEmail)
        val editTextPhone = rootView.findViewById<EditText>(R.id.editTextPhone)
        val buttonSaveChanges = rootView.findViewById<Button>(R.id.buttonSaveChanges)

        // Configurar los clics de los botones o eventos de la interfaz aquí


        // Por ejemplo, para cambiar la imagen de perfil
        buttonChangeProfilePicture.setOnClickListener {
            // Aquí implementar la lógica para cambiar la imagen de perfil
            // Puede ser una llamada a un selector de imágenes o una cámara
            // Y actualizar el imageViewProfile con la nueva imagen seleccionada
        }

        // Aquí puedes implementar la lógica para guardar los cambios
        buttonSaveChanges.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val phone = editTextPhone.text.toString()

            // Aquí puedes utilizar estos valores para guardar los cambios en el perfil
            // Por ejemplo, enviar estos datos a una base de datos o realizar alguna acción correspondiente
        }

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

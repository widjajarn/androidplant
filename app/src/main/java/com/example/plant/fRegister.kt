package com.example.plant

import android.os.Bundle
//import android.support.v4.app.Fragment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.SharedPreferences
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fRegister.newInstance] factory method to
 * create an instance of this fragment.
 */
class fRegister : Fragment() {
    // TODO: Rename and change types of parameters
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
        // Inflate the layout for this fragment
        var viewfrag =  inflater.inflate(R.layout.fragment_f_register, container, false)

        //        INISIALISASI DB
        var db = FirebaseFirestore.getInstance()

        var _etEmail : EditText = viewfrag.findViewById<EditText>(R.id.etEmail)
        var _etFullName : EditText = viewfrag.findViewById<EditText>(R.id.etFullName)
//        var _etBirthDate : EditText = viewfrag.findViewById<EditText>(R.id.etBirthDate)
//        var _etUsernameRegis : EditText = viewfrag.findViewById<EditText>(R.id.etUsernameRegis)
        var _etPasswordRegis : EditText = viewfrag.findViewById<EditText>(R.id.etPasswordRegis)

        val _btnRegister = viewfrag.findViewById<Button>(R.id.btnRegister)
        _btnRegister.setOnClickListener {
            val data = hashMapOf(
                "id" to null,
                "email" to _etEmail.text.toString(),
//                "username" to _etUsernameRegis.text.toString(),
                "password" to _etPasswordRegis.text.toString(),
                "fullname" to _etFullName.text.toString(),
//                "birthdate" to _etBirthDate.text.toString(),
                "thumbnail" to null,
                "joindate" to Calendar.getInstance().time
            )

            db.collection("Users").get()
                .addOnSuccessListener { result ->
                    var cek = 0;
                    for(document in result) {
                        if (document.data.get("email").toString() == _etEmail.text.toString()
                        ) {
                            cek += 1
                        }
                    }
                    if(cek == 0) {
                        var task = db.collection("Users").document()
                        data.set("id", task.id)
                        println("cek = " + task.id.toString());
                        db.collection("Users").document(task.id)
                            .set(data)
                            .addOnSuccessListener { result ->
                                println("cek berhasil simpan")
                                val mfLogin = fLogin()
                                val mFragmentManager = parentFragmentManager
                                mFragmentManager.beginTransaction().apply {
                                    replace(R.id.myframe, mfLogin, fRegister::class.java.simpleName)
                                    addToBackStack(null)
                                    commit()

                                    _etFullName.setText("")
                                    _etEmail.setText("")
//                                    _etBirthDate.setText("")
//                                    _etUsernameRegis.setText("")
                                    _etPasswordRegis.setText("")
                                }
                            }
                            .addOnFailureListener{
                                Log.d("Firebase", it.message.toString())
                            }
                    }
                    else {
                        Toast.makeText(
                            activity,
                            "Email is Already registered!",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
                .addOnFailureListener{
                    Log.d("Firebase", it.message.toString())
                }
        }

        val _tvgotofLogin = viewfrag.findViewById<TextView>(R.id.tvgotoLogin)
        _tvgotofLogin.setOnClickListener {
            val mfLogin = fLogin()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.myframe, mfLogin, fRegister::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        return viewfrag;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fRegister.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fRegister().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
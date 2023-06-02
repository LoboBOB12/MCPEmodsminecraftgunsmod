package uz.akbarali.fashion.ui.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.FragmentSettingsBinding
import uz.akbarali.fashion.ui.modal.MySharedPreferences


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(layoutInflater)
        MySharedPreferences.init(requireContext())
        binding.checkbox.isChecked = MySharedPreferences.loadData("check")
        binding.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            MySharedPreferences.save("check", isChecked)
        }
        binding.toolbar.title = getString(R.string.settings)
        return binding.root
    }

}
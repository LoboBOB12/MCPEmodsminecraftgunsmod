package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentRARBinding


class RARFragment : Fragment() {
    lateinit var binding: FragmentRARBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentRARBinding.inflate(layoutInflater)
        binding.toolbar.title = ".ZIP, .RAR"
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }


}
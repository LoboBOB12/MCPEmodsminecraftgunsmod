package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentALFArmamentBinding
import uz.akbarali.fashion.ui.modal.Download


class ALFArmamentFragment : Fragment() {
    lateinit var binding: FragmentALFArmamentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentALFArmamentBinding.inflate(layoutInflater)
        binding.toolbar.title = getString(R.string.a4)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8582",
                "https://addon-mcpe.com/engine/download.php?id=8582",
                "npa-christmas.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8582",
                "https://addon-mcpe.com/engine/download.php?id=8582",
                "npa-christmas.mcpack"
            )
        }
        return binding.root
    }


}
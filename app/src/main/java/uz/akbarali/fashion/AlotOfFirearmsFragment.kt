package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentAlotOfFirearmsBinding
import uz.akbarali.fashion.ui.modal.Download

class AlotOfFirearmsFragment : Fragment() {
    lateinit var binding: FragmentAlotOfFirearmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlotOfFirearmsBinding.inflate(layoutInflater)


        binding.toolbar.title = getString(R.string.rtet34t222)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8796",
                "https://addon-mcpe.com/engine/download.php?id=8796",
                "actualgunsb.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8795",
                "https://addon-mcpe.com/engine/download.php?id=8795",
                "actualgunsr.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8796",
                "https://addon-mcpe.com/engine/download.php?id=8796",
                "actualgunsb.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8795",
                "https://addon-mcpe.com/engine/download.php?id=8795",
                "actualgunsr.mcpack"
            )
        }
        return binding.root
    }

}
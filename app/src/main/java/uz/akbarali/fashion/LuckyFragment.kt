package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentLuckyBinding
import uz.akbarali.fashion.ui.modal.Download


class LuckyFragment : Fragment() {
    lateinit var binding: FragmentLuckyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLuckyBinding.inflate(layoutInflater)
        binding.toolbar.title =  getString(R.string.a11)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=1178",
                "https://addon-mcpe.com/engine/download.php?id=1178",
                "luckyblocksracev2.zip"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=1177",
                "https://addon-mcpe.com/engine/download.php?id=1177",
                "luckyblocksracev2.mcworld"
            )
        }

        return binding.root
    }


}
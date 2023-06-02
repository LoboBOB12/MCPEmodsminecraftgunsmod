package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentSpidermanUniverseBinding
import uz.akbarali.fashion.ui.modal.Download


class SpidermanUniverseFragment : Fragment() {
    lateinit var binding: FragmentSpidermanUniverseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpidermanUniverseBinding.inflate(layoutInflater)
        binding.toolbar.title =  getString(R.string.a6)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8437",
                "https://addon-mcpe.com/engine/download.php?id=8437",
                "spiderverse-behaviorpack.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8438",
                "https://addon-mcpe.com/engine/download.php?id=8438",
                "spiderverse-texturepack.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8437",
                "https://addon-mcpe.com/engine/download.php?id=8437",
                "spiderverse-behaviorpack.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=8438",
                "https://addon-mcpe.com/engine/download.php?id=8438",
                "spiderverse-texturepack.mcpack"
            )
        }
        return binding.root
    }

}
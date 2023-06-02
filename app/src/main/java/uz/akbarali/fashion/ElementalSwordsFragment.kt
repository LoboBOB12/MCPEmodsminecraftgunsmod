package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentElementalSwordsBinding
import uz.akbarali.fashion.ui.modal.Download

class ElementalSwordsFragment : Fragment() {
    lateinit var binding: FragmentElementalSwordsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElementalSwordsBinding.inflate(layoutInflater)
        binding.toolbar.title = getString(R.string.sq)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/download.php?id=8563",
                "https://addon-mcpe.com/engine/download.php?id=8563",
                "elementalswordsbpv4_1.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/download.php?id=8564",
                "https://addon-mcpe.com/engine/download.php?id=8564",
                "elementalswordsrpv4.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/download.php?id=8563",
                "https://addon-mcpe.com/engine/download.php?id=8563",
                "elementalswordsbpv4_1.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/download.php?id=8564",
                "https://addon-mcpe.com/engine/download.php?id=8564",
                "elementalswordsrpv4.mcpack"
            )
        }
        return binding.root
    }
}
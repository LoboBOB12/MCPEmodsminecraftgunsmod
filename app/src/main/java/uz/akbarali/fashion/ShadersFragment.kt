package uz.akbarali.fashion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.databinding.FragmentShadersBinding
import uz.akbarali.fashion.ui.modal.Download


class ShadersFragment : Fragment() {
    lateinit var binding: FragmentShadersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentShadersBinding.inflate(layoutInflater)
        binding.toolbar.title = "Шейдеры на улучшение факелов"
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=1174",
                "https://addon-mcpe.com/engine/download.php?id=1174",
                "dynamiclightspe.mcpack"
            )
        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=1175",
                "https://addon-mcpe.com/engine/download.php?id=1175",
                "dl-pe.zip"
            )
        }
        return binding.root
    }


}
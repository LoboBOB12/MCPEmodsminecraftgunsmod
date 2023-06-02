package uz.akbarali.fashion

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import uz.akbarali.fashion.databinding.FragmentDemonSlayerBinding
import uz.akbarali.fashion.ui.modal.Download


class DemonSlayerFragment : Fragment() {
    lateinit var binding: FragmentDemonSlayerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDemonSlayerBinding.inflate(layoutInflater)
        binding.toolbar.title = getString(R.string.a17)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding.button1.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())

                .setTitle(resources.getString(R.string.title))
                .setIcon(R.drawable.icon__3_)
                .setMessage(resources.getString(R.string.supporting_text))

                .setNegativeButton(resources.getString(R.string.decline)) { dialog, which ->
                    // Respond to negative button press
                }
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        .mkdirs()

                    val url = "https://addon-mcpe.com/engine/file.php?id=6967"
                    val request: DownloadManager.Request = DownloadManager.Request(Uri.parse(url))


                    request.setDescription("Downloading File please wait.....")
                    request.addRequestHeader(
                        "referer",
                        "https://addon-mcpe.com/engine/download.php?id=6967"
                    )
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setDestinationInExternalPublicDir(
                            Environment.DIRECTORY_DOWNLOADS,
                            "ani1_3bp.mcpack"
                        );


                    val downloadManager =
                        requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
                    downloadManager.enqueue(request)
                    Toast.makeText(requireContext(), "Downloading Started.", Toast.LENGTH_SHORT)
                        .show()

                }.show()

        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=6966",
                "https://addon-mcpe.com/engine/download.php?id=6966",
                "akuma-no-isan-rp.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=6966",
                "https://addon-mcpe.com/engine/download.php?id=6966", "ani1_3bp.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(),
                "https://addon-mcpe.com/engine/file.php?id=6967",
                "https://addon-mcpe.com/engine/download.php?id=6967", "akuma-no-isan-rp.mcpack"
            )
        }
        return binding.root
    }

}
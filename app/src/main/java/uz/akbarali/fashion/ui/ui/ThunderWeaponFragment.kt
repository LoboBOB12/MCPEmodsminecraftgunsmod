package uz.akbarali.fashion.ui.ui

import android.app.AlertDialog
import android.app.DownloadManager
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.FragmentThunderWeaponBinding
import uz.akbarali.fashion.ui.modal.Download


class ThunderWeaponFragment : Fragment() {
    var writeAcess = false
    private val PERMISSION_REQUEST_CODE = 1234
    var manager: DownloadManager? = null
    private lateinit var binding: FragmentThunderWeaponBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun checkWriteAccess() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Toast.makeText(this,"starting download..1..",Toast.LENGTH_LONG).show()
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) !=
                PackageManager.PERMISSION_GRANTED
            ) {
                if (shouldShowRequestPermissionRationale(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    val builder = AlertDialog.Builder(activity)
                    builder.setMessage("Required permission to write external storage to save downloaded file.")
                    builder.setTitle("Please Grant Write Permission")
                    builder.setPositiveButton("OK") { _, _ ->
                        ActivityCompat.requestPermissions(
                            requireActivity(),
                            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            PERMISSION_REQUEST_CODE
                        )
                    }
                    builder.setNeutralButton("Cancel", null)
                    val dialog = builder.create()
                    dialog.show()
                } else {

                    ActivityCompat.requestPermissions(
                        requireActivity(),
                        arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        PERMISSION_REQUEST_CODE
                    )
                }
            } else {
                /**
                 * Already have required permission.
                 * */
                //Toast.makeText(this, "cannot start download", Toast.LENGTH_LONG).show()
                writeAcess = false
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(requireContext(), "starting download 2..", Toast.LENGTH_LONG)
                        .show()
                    writeAcess = true
                } else {
                    // Permission denied
                    writeAcess = false
                    Toast.makeText(
                        context,
                        "Permission Denied. This app will not work with right permission.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThunderWeaponBinding.inflate(layoutInflater)
        checkWriteAccess()
        binding.toolbar.title = getString(R.string.sq)
        binding.toolbar.setNavigationIcon(R.drawable.icon)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding.button1.setOnClickListener {
            Download.linkFromDownload(
                requireContext(), "https://addon-mcpe.com/engine/file.php?id=8826",
                "https://addon-mcpe.com/engine/download.php?id=8826", "thunder-weapons-rp.mcpack"
            )

        }
        binding.button2.setOnClickListener {
            Download.linkFromDownload(
                requireContext(), "https://addon-mcpe.com/engine/download.php?id=8827",
                "https://addon-mcpe.com/engine/download.php?id=8827", "thunder-weapons-bp.mcpack"
            )
        }
        binding.button3.setOnClickListener {
            Download.linkFromDownload(
                requireContext(), "https://addon-mcpe.com/engine/file.php?id=8826",
                "https://addon-mcpe.com/engine/download.php?id=8826", "thunder-weapons-rp.mcpack"
            )
        }
        binding.button4.setOnClickListener {
            Download.linkFromDownload(
                requireContext(), "https://addon-mcpe.com/engine/download.php?id=8827",
                "https://addon-mcpe.com/engine/download.php?id=8827", "thunder-weapons-bp.mcpack"
            )
        }

        return binding.root
    }


}





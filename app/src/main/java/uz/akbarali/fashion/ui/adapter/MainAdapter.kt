package uz.akbarali.fashion.ui.adapter


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView
import uz.akbarali.fashion.R
import uz.akbarali.fashion.databinding.LayoutAdBinding
import uz.akbarali.fashion.databinding.MenuItemBinding
import uz.akbarali.fashion.ui.modal.Fashion


class MainAdapter(
    private val activity: Activity,
    mainList: List<Fashion>,
    var myClickListener: MainAdapter.MyClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mainList: List<Fashion>

    init {
        this.mainList = mainList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(activity)
        return if (viewType == ITEM_VIEW) {
            val view: View = layoutInflater.inflate(R.layout.menu_item, parent, false)
            MainViewHolder(view)
        } else (if (viewType == AD_VIEW) {
            val view: View = layoutInflater.inflate(R.layout.layout_ad, parent, false)
            AdViewHolder(view)
        } else {
            null
        })!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == ITEM_VIEW) {
            val pos = position - Math.round((position / ITEM_FEED_COUNT).toFloat())
            (holder as MainViewHolder).bindData(mainList[position],position)
        } else if (holder.itemViewType == AD_VIEW) {
            (holder as AdViewHolder).bindAdData()
        }
    }

    override fun getItemCount(): Int {
        return if (mainList.isNotEmpty()) {
            mainList.size + Math.round((mainList.size / ITEM_FEED_COUNT).toFloat())
        } else mainList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % ITEM_FEED_COUNT == 0) {
            AD_VIEW
        } else ITEM_VIEW
    }

    private fun populateNativeADView(nativeAd: NativeAd, adView: NativeAdView) {
        // Set the media view.
        adView.mediaView = adView.findViewById(R.id.ad_media)

        // Set other ad assets.
        adView.headlineView = adView.findViewById(R.id.ad_headline)
        adView.bodyView = adView.findViewById(R.id.ad_body)
        adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
        adView.iconView = adView.findViewById(R.id.ad_app_icon)
        adView.priceView = adView.findViewById(R.id.ad_price)
        adView.starRatingView = adView.findViewById(R.id.ad_stars)
        adView.storeView = adView.findViewById(R.id.ad_store)
        adView.advertiserView = adView.findViewById(R.id.ad_advertiser)

        // The headline and mediaContent are guaranteed to be in every UnifiedNativeAd.
        (adView.headlineView as TextView?)?.text = nativeAd.headline
        adView.mediaView!!.mediaContent = nativeAd.mediaContent

        // These assets aren't guaranteed to be in every UnifiedNativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.body == null) {
            adView.bodyView!!.visibility = View.INVISIBLE
        } else {
            adView.bodyView!!.visibility = View.VISIBLE
            (adView.bodyView as TextView?)?.text = nativeAd.body
        }
        if (nativeAd.callToAction == null) {
            adView.callToActionView!!.visibility = View.INVISIBLE
        } else {
            adView.callToActionView!!.visibility = View.VISIBLE
            (adView.callToActionView as Button?)?.text = nativeAd.callToAction
        }
        if (nativeAd.icon == null) {
            adView.iconView!!.visibility = View.GONE
        } else {
            (adView.iconView as ImageView?)?.setImageDrawable(
                nativeAd.icon!!.drawable
            )
            adView.iconView!!.visibility = View.VISIBLE
        }
        if (nativeAd.price == null) {
            adView.priceView!!.visibility = View.INVISIBLE
        } else {
            adView.priceView!!.visibility = View.VISIBLE
            (adView.priceView as TextView?)?.text = nativeAd.price
        }
        if (nativeAd.store == null) {
            adView.storeView!!.visibility = View.INVISIBLE
        } else {
            adView.storeView!!.visibility = View.VISIBLE
            (adView.storeView as TextView?)?.text = nativeAd.store
        }
        if (nativeAd.starRating == null) {
            adView.starRatingView!!.visibility = View.INVISIBLE
        } else {
            (adView.starRatingView as RatingBar?)!!.rating = nativeAd.starRating!!.toFloat()
            adView.starRatingView!!.visibility = View.VISIBLE
        }
        if (nativeAd.advertiser == null) {
            adView.advertiserView!!.visibility = View.INVISIBLE
        } else {
            (adView.advertiserView as TextView?)?.text = nativeAd.advertiser
            adView.advertiserView!!.visibility = View.VISIBLE
        }

        // This method tells the Google Mobile Ads SDK that you have finished populating your
        // native ad view with this native ad.
        adView.setNativeAd(nativeAd)
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: MenuItemBinding

        init {
            binding = MenuItemBinding.bind(itemView)
        }

        fun bindData(fashion: Fashion, position: Int) {
            if (position == 1 || position == 3 || position == 5 || position == 7 || position == 9 || position == 11 || position == 13) {
                binding.moreBtn.visibility = View.INVISIBLE
                binding.downloadBtn.setBackgroundResource(R.drawable.button__2_)
                binding.downloadBtn.setOnClickListener {
                    myClickListener.onClick(fashion, position)
                }
            }
            binding.image.setImageResource(fashion.image)
            binding.title.text = fashion.title
            binding.description.text = fashion.description

            binding.moreBtn.setOnClickListener {
                myClickListener.onClick(fashion, position)
            }
            binding.downloadBtn.setOnClickListener {
                myClickListener.download(fashion, position)
            }
        }
    }

    inner class AdViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding: LayoutAdBinding

        init {
            binding = LayoutAdBinding.bind(itemView)
        }

        fun bindAdData() {
            val builder = AdLoader.Builder(activity,"ca-app-pub-2782660208341547/5682820875")
                .forNativeAd { nativeAd ->
                    val nativeAdView = activity.layoutInflater.inflate(
                        R.layout.layout_native_ad,
                        null
                    ) as NativeAdView
                    populateNativeADView(nativeAd, nativeAdView)
                    binding.adLayout.removeAllViews()
                    binding.adLayout.addView(nativeAdView)
                }
            val adLoader = builder.withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    super.onAdFailedToLoad(loadAdError)
                    Toast.makeText(activity, loadAdError.message, Toast.LENGTH_SHORT).show()
                }
            }).build()
            adLoader.loadAd(AdRequest.Builder().build())
        }
    }

    companion object {
        private const val ITEM_VIEW = 0
        private const val AD_VIEW = 1
        private const val ITEM_FEED_COUNT = 6
    }

    interface MyClickListener {
        fun onClick(fashion: Fashion, position: Int)
        fun download(fashion: Fashion, position: Int)
    }
}
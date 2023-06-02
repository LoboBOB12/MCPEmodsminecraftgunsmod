//package uz.akbarali.fashion.ui.adapter
//
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.google.android.gms.ads.AdView
//import uz.akbarali.fashion.R
//import uz.akbarali.fashion.ui.MainActivity
//import uz.akbarali.fashion.ui.modal.Fashion
//
//
//class MyRecyclerViewAdapter internal constructor(
//    private val mList: ArrayList<Any>,
//    private val mItemClickListener: MyRecyclerViewItemClickListener
//) :
//    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            ITEM_TYPE_BANNER_AD -> {
//                //Inflate ad banner container
//                val bannerLayoutView: View = LayoutInflater.from(parent.context)
//                    .inflate(R.layout.banner_ad_row, parent, false)
//
//                //Create View Holder
//                MyAdViewHolder(bannerLayoutView)
//            }
//            ITEM_TYPE_COUNTRY -> {
//
//                //Inflate RecyclerView row
//                val view: View =
//                    LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
//
//                //Create View Holder
//                val myCountryViewHolder: MyCountryViewHolder = MyCountryViewHolder(view)
//
//                //Item Clicks
//                myCountryViewHolder.itemView.setOnClickListener(object : View.OnClickListener {
//                    fun onClick(v: View?) {
//                        mItemClickListener.onItemClicked(mList[myCountryViewHolder.layoutPosition] as Country)
//                    }
//                })
//                myCountryViewHolder
//            }
//            else -> {
//                val view: View =
//                    LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
//                val myCountryViewHolder: MyCountryViewHolder = MyCountryViewHolder(view)
//                myCountryViewHolder.itemView.setOnClickListener(object : View.OnClickListener{
//                    fun onClick(v: View?) {
//                        mItemClickListener.onItemClicked(mList[myCountryViewHolder.layoutPosition] as Country)
//                    }
//                })
//                myCountryViewHolder
//            }
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val viewType = getItemViewType(position)
//        when (viewType) {
//            ITEM_TYPE_BANNER_AD -> if (mList[position] is AdView) {
//                val bannerHolder = holder as MyAdViewHolder
//                val adView = mList[position] as AdView
//                val adCardView = bannerHolder.itemView as ViewGroup
//                // The AdViewHolder recycled by the RecyclerView may be a different
//                // instance than the one used previously for this position. Clear the
//                // AdViewHolder of any subviews in case it has a different
//                // AdView associated with it, and make sure the AdView for this position doesn't
//                // already have a parent of a different recycled AdViewHolder.
//                if (adCardView.childCount > 0) {
//                    adCardView.removeAllViews()
//                }
//                if (adView.parent != null) {
//                    (adView.parent as ViewGroup).removeView(adView)
//                }
//
//                // Add the banner ad to the ad view.
//                adCardView.addView(adView)
//            }
//            ITEM_TYPE_COUNTRY -> if (mList[position] is Fashion) {
//                val myCountryViewHolder = holder as MyCountryViewHolder
//                val country: Fashion= mList[position] as Fashion
//
//                //Set Country Name
//                myCountryViewHolder.textViewName.setText(country.getName())
//
//                //Set Capital
//                val capital = "Capital: " + country.getCapital()
//                myCountryViewHolder.textViewCapital.text = capital
//
//                //Set Currency
//                val currency = "Currency: " + country.getCurrency()
//                myCountryViewHolder.textViewCurrency.text = currency
//
//                //Set Continent
//                val continent = "Continent: " + country.getContinent()
//                myCountryViewHolder.textViewContinent.text = continent
//            }
//            else -> if (mList[position] is Country) {
//                val myCountryViewHolder = holder as MyCountryViewHolder
//                val country: Country = mList[position] as Country
//                myCountryViewHolder.textViewName.setText(country.getName())
//                val capital = "Capital: " + country.getCapital()
//                myCountryViewHolder.textViewCapital.text = capital
//                val currency = "Currency: " + country.getCurrency()
//                myCountryViewHolder.textViewCurrency.text = currency
//                val continent = "Continent: " + country.getContinent()
//                myCountryViewHolder.textViewContinent.text = continent
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return mList.size()
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return if (position == 0 || mList[position] is Country) {
//            ITEM_TYPE_COUNTRY
//        } else {
//            if (position % MainActivity.ITEMS_PER_AD === 0) ITEM_TYPE_BANNER_AD else ITEM_TYPE_COUNTRY
//        }
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    //Country View Holder
//    internal inner class MyCountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val textViewName: TextView
//        private val textViewCapital: TextView
//        private val textViewCurrency: TextView
//        private val textViewContinent: TextView
//
//        init {
//            textViewName = itemView.findViewById(R.id.countryName)
//            textViewCapital = itemView.findViewById(R.id.capital)
//            textViewCurrency = itemView.findViewById(R.id.currency)
//            textViewContinent = itemView.findViewById(R.id.continent)
//        }
//    }
//
//    //Banner Ad View Holder
//    internal inner class MyAdViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
//
//    //Country Item Click Listener
//    interface MyRecyclerViewItemClickListener {
//        fun onItemClicked(country: Country?)
//    }
//
//    companion object {
//        private const val ITEM_TYPE_COUNTRY = 0
//        private const val ITEM_TYPE_BANNER_AD = 1
//    }
//}
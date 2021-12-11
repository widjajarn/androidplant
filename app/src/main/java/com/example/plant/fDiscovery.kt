package com.example.plant

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import java.text.FieldPosition

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fDiscovery.newInstance] factory method to
 * create an instance of this fragment.
 */
class fDiscovery : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager2 : ViewPager2;

    //    MAKE AUTOMATIC
    private var carouselHandler : Handler = Handler();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        viewPager2.registerOnPageChangeCallback(viewPager2.OnPageChangeCallBack() {
//            @Override
//            fun onPageSelected(int position){
//
//            }
//        });
//        var carouselRunnable : Runnable = Runnable() {
//            @Override
//            fun run() {
//                viewPager2.setCurrentItem(viewPager2.currentItem + 1)
//            }
//        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Toast.makeText(activity, "aaa", Toast.LENGTH_SHORT).show();

        var viewfrag = inflater.inflate(R.layout.fragment_f_discovery, container, false)

        viewPager2 = viewfrag.findViewById<ViewPager2>(R.id.vpCarousel);

        var carouselItems = arrayListOf<CarouselItem>();

        carouselItems.add(CarouselItem(R.drawable.img1))
        carouselItems.add(CarouselItem(R.drawable.img2))
        carouselItems.add(CarouselItem(R.drawable.img3))
        carouselItems.add(CarouselItem(R.drawable.img4))
        carouselItems.add(CarouselItem(R.drawable.img5))

        viewPager2.setAdapter(CarouselAdapter(carouselItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        var compositePageTransformer: CompositePageTransformer = CompositePageTransformer();
        compositePageTransformer.addTransformer(MarginPageTransformer(40));
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer() { view: View,
                                                                               fl: Float ->
            @Override
            fun transformPage() {
                println("MASUKK TRANSFORM");
                var r : Float = 1 - Math.abs(fl);
                view.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                carouselHandler.removeCallbacks(sliderRunnable)
                carouselHandler.postDelayed(sliderRunnable, 1000)
            }
        })


        return viewfrag;
    }

    private val sliderRunnable =
        Runnable { viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1) }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fDiscovery.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fDiscovery().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

//budiono mau tahu tek
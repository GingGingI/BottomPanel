package com.example.ginggingi.bottompanel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.btn_layout.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var bottomsSheetBehavior: BottomSheetBehavior<RelativeLayout>
    private lateinit var secbottomSheetBehavior: BottomSheetBehavior<RelativeLayout>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomsSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheet))
//        secbottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.secbottomSheet))

        Btn1.setOnClickListener(this)
        Btn2.setOnClickListener(this)
        bottomsSheetBehavior.setBottomSheetCallback( object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    SheetTxv1.setText("asdfsadfsadfadfasdf")
                } else {
                    SheetTxv1.setText("111111111111111111")
                }

                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Log.i("BSB", "Callapsed")
                        bottomsSheetBehavior.peekHeight = 0
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Log.i("BSB", "EXPANDED")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Log.i("BSB", "Dragging")
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Log.i("BSB", "Hidden")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        Log.i("BSB", "Setting")
                    }
                }
            }

        })

    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.Btn1 -> {
                CustomBottomSheet().show(supportFragmentManager, "BottomSheet")
                bottomsSheetBehavior.peekHeight = 120
            }
            R.id.Btn2 -> {
                SecondCustomBottomSheet().show(supportFragmentManager, "SecBottomSheet")
//                secbottomSheetBehavior.peekHeight = 150

            }
        }
    }
}

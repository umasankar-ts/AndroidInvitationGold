package com.example.invitation


import android.app.Fragment
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.os.CountDownTimer
import kotlinx.android.synthetic.main.fragment_home.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    var countdownTimer:CountDownTimer?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        startCountdownTimer()
        return view
    }

    private fun startCountdownTimer() {

        val currentMilliSecond: Long = System.currentTimeMillis();
        val sdf = SimpleDateFormat("dd-M-yyyy hh:mm:ss")
        val dateString = "23-06-2019 09:30:00"
        val date:Date = sdf.parse(dateString)
        val calendar = Calendar.getInstance()
        calendar.setTime(date);
        val millisInfuture:Long =calendar.timeInMillis - currentMilliSecond

       countdownTimer = object : CountDownTimer(millisInfuture, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                /*            converting the milliseconds into days, hours, minutes and seconds and displaying it in textviews             */

                tv_day.text = (TimeUnit.HOURS.toDays(TimeUnit.MILLISECONDS.toHours(millisUntilFinished))) .toString()

                tv_hour.text = (
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished) - TimeUnit.DAYS.toHours(
                            TimeUnit.MILLISECONDS.toDays(
                                millisUntilFinished
                            )
                        )) .toString()

                tv_minute.text = (
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                            TimeUnit.MILLISECONDS.toHours(
                                millisUntilFinished
                            )
                        )) .toString()

                tv_sec.text = (
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        )) .toString()
            }

            override fun onFinish() {
                /*            clearing all fields and displaying countdown finished message             */

                tv_day.setText("Count down completed")
                tv_hour.setText("")
                tv_minute.setText("")
                tv_sec.setText("")
            }
        }

        (countdownTimer as CountDownTimer).start()
    }

    override fun onResume() {
        (countdownTimer as CountDownTimer).start()
        super.onResume()
    }

    override fun onStop() {
        (countdownTimer as CountDownTimer).cancel()
        super.onStop()
    }
}

package com.aswin.tictactoe

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {
    lateinit var bottom_left : ImageView
    lateinit var bottom_middle : ImageView
    lateinit var bottom_right : ImageView
    lateinit var middle_left : ImageView
    lateinit var middle : ImageView
    lateinit var middle_right : ImageView
    lateinit var top_left : ImageView
    lateinit var top_middle : ImageView
    lateinit var top_right : ImageView
    lateinit var reset : Button
    lateinit var win_slash_bottom:ImageView
    lateinit var win_slash_middle:ImageView
    lateinit var win_slash_top:ImageView
    lateinit var win_slash_topdown_left:ImageView
    lateinit var win_slash_topdown_middle:ImageView
    lateinit var win_slash_topdown_right:ImageView
    lateinit var win_slash_diagonal:ImageView
    lateinit var win_slash_diagonal_reverse : ImageView

    var tapped = false
    var x = mutableListOf<Boolean>(
        false,false,false,
        false,false,false,
        false,false,false
    )

    var content = mutableListOf<String>(
        "","","",
        "","","",
        "","","",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset = findViewById(R.id.reset)
        bottom_left = findViewById(R.id.bottom_left)
        bottom_middle = findViewById(R.id.bottom_middle)
        bottom_right = findViewById(R.id.bottom_right)
        middle_left = findViewById(R.id.middle_left)
        middle = findViewById(R.id.middle)
        middle_right = findViewById(R.id.middle_right)
        top_left = findViewById(R.id.top_left)
        top_middle = findViewById(R.id.top_middle)
        top_right = findViewById(R.id.top_right)
        win_slash_bottom = findViewById(R.id.win_slash_bottom)
        win_slash_middle = findViewById(R.id.win_slash_middle)
        win_slash_top = findViewById(R.id.win_slash_top)
        win_slash_topdown_left = findViewById(R.id.win_slash_topdown_left)
        win_slash_topdown_middle = findViewById(R.id.win_slash_topdown_middle)
        win_slash_topdown_right = findViewById(R.id.win_slash_topdown_right)
        win_slash_diagonal = findViewById(R.id.win_slash_diagonal)
        win_slash_diagonal_reverse = findViewById(R.id.win_slash_diagonal_reverse)

        win_slash_bottom.visibility = View.GONE
        win_slash_middle.visibility = View.GONE
        win_slash_top.visibility = View.GONE
        win_slash_topdown_left.visibility = View.GONE
        win_slash_topdown_middle.visibility = View.GONE
        win_slash_topdown_right.visibility = View.GONE
        win_slash_diagonal.visibility = View.GONE
        win_slash_diagonal_reverse.visibility = View.GONE

        bottom_left.setOnClickListener{
            if(!x[0]){
                if(!tapped){
                    bottom_left.setImageResource(R.drawable.circle)
                    content[0] = "o"
                }else{
                    bottom_left.setImageResource(R.drawable.cross)
                    content[0] = "x"
                }
                tapped = !tapped
                x[0]= true
            }
            wincheck()

        }

        bottom_middle.setOnClickListener{
            if(!x[1]){
                if(!tapped){
                    bottom_middle.setImageResource(R.drawable.circle)
                    content[1] = "o"
                }else{
                    bottom_middle.setImageResource(R.drawable.cross)
                    content[1] = "x"

                }
                tapped = !tapped
                x[1]= true
            }
            wincheck()

        }

        bottom_right.setOnClickListener{
            if(!x[2]){
                if(!tapped){
                    bottom_right.setImageResource(R.drawable.circle)
                    content[2] = "o"
                }else{
                    bottom_right.setImageResource(R.drawable.cross)
                    content[2] = "x"

                }
                tapped = !tapped
                x[2]= true
            }
            wincheck()
        }

        middle_left.setOnClickListener{
            if(!x[3]){
                if(!tapped){
                    middle_left.setImageResource(R.drawable.circle)
                    content[3] = "o"
                }else{
                    middle_left.setImageResource(R.drawable.cross)
                    content[3] = "x"
                }
                tapped = !tapped
                x[3]= true
            }
            wincheck()

        }

        middle.setOnClickListener{
            if(!x[4]){
                if(!tapped){
                    middle.setImageResource(R.drawable.circle)
                    content[4] = "o"
                }else{
                    middle.setImageResource(R.drawable.cross)
                    content[4] = "x"
                }
                tapped = !tapped
                x[4]= true
            }
            wincheck()
        }

        middle_right.setOnClickListener{
            if(!x[5]){
                if(!tapped){
                    middle_right.setImageResource(R.drawable.circle)
                    content[5]="o"
                }else{
                    middle_right.setImageResource(R.drawable.cross)
                    content[5]="x"
                }
                tapped = !tapped
                x[5]= true
            }
            wincheck()
        }

        top_left.setOnClickListener{
            if(!x[6]){
                if(!tapped){
                    top_left.setImageResource(R.drawable.circle)
                    content[6]="o"
                }else{
                    top_left.setImageResource(R.drawable.cross)
                    content[6]="x"

                }
                tapped = !tapped
                x[6]= true
            }
            wincheck()
        }

        top_middle.setOnClickListener{
            if(!x[7]){
                if(!tapped){
                    top_middle.setImageResource(R.drawable.circle)
                    content[7] = "o"
                }else{
                    top_middle.setImageResource(R.drawable.cross)
                    content[7] = "x"

                }
                tapped = !tapped
                x[7]= true
            }
            wincheck()
        }

        top_right.setOnClickListener{
            if(!x[8]){
                if(!tapped){
                    top_right.setImageResource(R.drawable.circle)
                    content[8] = "o"
                }else{
                    top_right.setImageResource(R.drawable.cross)
                    content[8] = "x"

                }
                tapped = !tapped
                x[8]= true
            }
            wincheck()

        }

        reset.setOnClickListener {
            recreate()
        }


    }
    fun wincheck():Unit{
        val delay:Long = 3000
        if((content[0]==content[1]) && (content[1]==content[2])&&(content[0]!="")&&(content[1]!="")&&(content[2]!="")){
            win_slash_bottom.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )
        }
        else if((content[3]==content[4]) && (content[4]==content[5])&&(content[3]!="")&&(content[4]!="")&&(content[5]!="")){
            win_slash_middle.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )
        }
        else if((content[6]==content[7])&&(content[7]==content[8])&&(content[6]!="")&&(content[7]!="7")&&(content[8]!="")){
            win_slash_top.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )
        }
        else if((content[0]==content[3])&&(content[3]==content[6])&&(content[0]!="")&&(content[3]!="")&&(content[6]!="")){
            win_slash_topdown_left.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )

        }
        else if((content[1]==content[4])&&(content[4]==content[7])&&(content[1]!="")&&(content[4]!="")&&(content[7]!="")){
            win_slash_topdown_middle.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )

        }
        else if((content[2]==content[5])&&(content[5]==content[8])&&(content[2]!="")&&(content[5]!="")&&(content[8]!="")){
            win_slash_topdown_right.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )
        }
        else if((content[0]==content[4])&&(content[4]==content[8])&&(content[0]!="")&&(content[4]!="")&&(content[8]!="")){
            win_slash_diagonal_reverse.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )

        }
        else if((content[6]==content[4])&&(content[4]==content[2])&&(content[6]!="")&&(content[4]!="")&&(content[2]!="")){
            win_slash_diagonal.visibility = View.VISIBLE
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )

        }
        else{
            for(i in 0 until content.size){
                if(content[i]==""){
                    return
                }
            }
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Handler().postDelayed(
                {recreate()},
                delay
            )
        }
    }
}

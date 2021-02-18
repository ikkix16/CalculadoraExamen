package barreras.mario.Calculadora
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn1: Button = findViewById(R.id.id1) as Button
        val btn2: Button = findViewById(R.id.id2) as Button
        val btn3: Button = findViewById(R.id.id3) as Button
        val btn4: Button = findViewById(R.id.id4) as Button
        val btn5: Button = findViewById(R.id.id5) as Button
        val btn6: Button = findViewById(R.id.id6) as Button
        val btn7: Button = findViewById(R.id.id7) as Button
        val btn8: Button = findViewById(R.id.id8) as Button
        val btn9: Button = findViewById(R.id.id9) as Button
        val btn0: Button = findViewById(R.id.id0) as Button
        val btnplus: Button = findViewById(R.id.idplus) as Button
        val btnless: Button = findViewById(R.id.idless) as Button
        val btnx: Button = findViewById(R.id.idx) as Button
        val btndiv: Button = findViewById(R.id.iddiv) as Button
        val btnResult: Button = findViewById(R.id.idResult) as Button
        val btnClear: Button = findViewById(R.id.idClear) as Button

        val txOperacion: TextView = findViewById(R.id.idOperacion) as TextView
        val txResultado: TextView = findViewById(R.id.idResultado) as TextView

        fun agregarExpresion(string: String, valor: Boolean) {
            if (idResultado.text.isNotEmpty()) {
                idOperacion.text = ""
            }

            if (valor) {
                idResultado.text = ""
                idOperacion.append(string)
            } else {
                idOperacion.append(idResultado.text)
                idOperacion.append(string)
                idResultado.text = ""
            }

        }




        //numeros
        btn1.setOnClickListener{agregarExpresion("1",true)

        }

        btn2.setOnClickListener { agregarExpresion("2",true)
        }

        btn3.setOnClickListener { agregarExpresion("3",true)
        }

        btn4.setOnClickListener { agregarExpresion("4",true)
        }
        btn5.setOnClickListener { agregarExpresion("5",true)
        }
        btn6.setOnClickListener { agregarExpresion("6",true)
        }
        btn7.setOnClickListener { agregarExpresion("7",true)
        }
        btn8.setOnClickListener { agregarExpresion("8",true)
        }
        btn9.setOnClickListener { agregarExpresion("9",true)
        }
        btn0.setOnClickListener { agregarExpresion("0",true)
        }

        //operaciones


        btnless.setOnClickListener { agregarExpresion("-",false)
        }

        btnx.setOnClickListener { agregarExpresion("*",false)

        }

        btndiv.setOnClickListener { agregarExpresion("/",false)


        }
        btnplus.setOnClickListener{ agregarExpresion("+",false)

        }


        //acciones
        btnResult.setOnClickListener {
            try {

                val operacion = ExpressionBuilder(idOperacion.text.toString()).build()
                val resultado = operacion.evaluate()
                val longResult = resultado.toLong()
                if(resultado == longResult.toDouble())
                    idResultado.text = longResult.toString()
                else
                    idResultado.text = resultado.toString()

            }catch (e:Exception){
                Log.d("Exception"," Mensaje : " + e.message )
            }
        }


        btnClear.setOnClickListener {
            txOperacion.setText("")
            txResultado.setText("")
        }



    }
}

package edu.itesm.lg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.DeadObjectException
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var tiros_jug1 = 1
    var tiros_jug2 = 1
    var total1 = 0
    var total2 = 0
    var flag : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Mensajes para programador
        Log.i("edu.itesm.daec", "demostracion de log")
        //test_kotlin()

        roll_dice.text = "Tira jugador 1"
        roll_dice.setOnClickListener {

            if(flag == false){
                jugador_uno()
            } else if (flag == true){
                jugador_dos()

            }

            if( tiros_jug1 == 5){
                reset()
            }
        }
    }

    fun jugador_uno(){
        flag = true
        val rand1 = Random.nextInt(2,6)
        if ( tiros_jug1 < 4){
            total1 = rand1 + total1
        }
        mensaje.text = "Jugador 1 saco: $rand1 Numero de tiro: ${tiros_jug1++}"
        roll_dice.text = "Tira jugador 2"
    }

    fun jugador_dos(){
        flag = false
        val rand2 = Random.nextInt(2,6)
        total2 = rand2 + total2
        roll_dice.text = "Tira jugador 1"
        mensaje.text = "Jugador 2 saco: $rand2 Numero de tiro: ${tiros_jug2++}"

        if (tiros_jug2 == 4){
            roll_dice.text = "Mostrar Resultados"
        }
    }

    fun reset(){
        if (total1 > total2){
            mensaje.text = "Puntos Jugador 1: $total1  Puntos Jugador 2: $total2 Gano el jugador 1 "
        } else if (total2 > total1){
            mensaje.text = "Puntos Jugador 1: $total1  Puntos Jugador 2: $total2 Gano el jugador 2"
        } else {
            mensaje.text = "Puntos Jugador 1: $total1  Puntos Jugador 2: $total2 Empate"
        }

        roll_dice.text = "Volver a Jugar"

        // eliminamos

        flag = false
        tiros_jug1 = 1
        tiros_jug2 = 1
        total1 = 0
        total2 = 0
    }

    fun test_kotlin(){
        // comentario
        /*
        * Bloque de Comentario
        */
        var edad = 45
        val peso : Double = 67.7
        val altura : Float = 1.58F
        Log.i("edu.itesm.daec",imc(peso,altura))
        //print(imc(peso,altura) )
    }

    fun imc(peso: Double, altura: Float) : String {
        val imc_cal = peso / altura * altura
        val imc_str = if(imc_cal > 18.5 && imc_cal < 25){

            "$imc_cal normal"

        }else if(imc_cal > 25 && imc_cal < 30){
            "$imc_cal sobre peso"
        }else {
            "$imc_cal obesidad"
        }
        return imc_str
    }

}

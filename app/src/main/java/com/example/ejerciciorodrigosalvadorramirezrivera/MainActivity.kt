package com.example.ejerciciorodrigosalvadorramirezrivera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var et_Nombre: EditText
    private lateinit var et_Apellido:EditText
    private lateinit var sp_Departamento: Spinner
    private lateinit var sp_Municipio:Spinner
    private lateinit var rbMasculino:RadioButton
    private lateinit var rbFemenino:RadioButton
    private lateinit var et_Telefono:EditText
    private lateinit var tvDatos:TextView
    private val Datos= arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se asignan los objetos de la vista a las variables anteriores
        et_Nombre = findViewById(R.id.et_Nombre)
        et_Apellido = findViewById(R.id.et_Apellido)
        sp_Departamento = findViewById(R.id.sp_Departamento)
        sp_Municipio = findViewById(R.id.sp_Municipio)
        rbMasculino = findViewById(R.id.rbMasculino)
        rbFemenino = findViewById(R.id.rbFemenino)
        et_Telefono = findViewById(R.id.et_Telefono)
        tvDatos = findViewById(R.id.tv_Datos)

        //Lenando el spinner de Departamentos
        val departamentos = arrayOf(
            "Seleccione una opcion",
            "San Salvador",
            "Chalatenango",
            "Sonsonate",
            "La Paz",
            "La Libertad",
            "San Miguel",
            "Usulután",
            "Cabañas",
            "Santa Ana",
            "San Vicente",
            "La Unión",
            "Morazán",
            "Cuscatlán",
            "Ahuachapán"
        )
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, departamentos)
        sp_Departamento.adapter = adaptador

        //Funcion para recoger un listado de municipios de acuerdo a un departamento
        fun getMunicipios(departamento:String):ArrayList<String>{
            val municipios= arrayListOf<String>()
            when(departamento){
                "Chalatenango"->municipios.addAll(listOf("Seleccione una opcion","Agua Caliente","Arcatao","Azacualpa","Chalatenango","Citalá","Comalapa","Concepción Quezaltepeque",
                    "Dulce Nombre de María","El Carrizal","El Paraíso","La Laguna","La Palma","La Reina","Las Vueltas","Nombre de Jesús","Nueva Concepción",
                    "Nueva Trinidad","Ojos de Agua","Potonico","San Antonio de la Cruz","San Antonio Los Ranchos","San Fernando","San Francisco Lempa",
                    "San Francisco Morazán","San Ignacio","San Isidro Labrador","San José Cancasque (Cancasque)","San José Las Flores","San Luis del Carmen",
                    "San Miguel de Mercedes","San Rafael","Santa Rita","Tejutla"))
                "San Salvador"->municipios.addAll(listOf("Seleccione una opcion","Aguilares","Apopa","Ayutuxtepeque","Ciuddad Delgado","Cuscatancingo","El Paisnal","Guazapa","Ilopango",
                    "Mejicanos","Nejapa","Panchimalco","Rosario de Mora","San Marcos","San Martín","San Salvador","Santiago Texacuangos","Santo Tomás",
                    "Soyapango","Tonacatepeque"))
                "Sonsonate"->municipios.addAll(listOf("Seleccione una opcion","Acajutla","Armenia","Caluco","Cuisnahuat","Izalco","Juayúa","Nahuizalco","Nahulingo","Salcoatitán",
                    "San Antonio del Monte","San Julián","Santa Catarina Masahuat","Santa Isabel Ishuatán","Santo Domingo de Guzmán","Sonsonate",
                    "Sonzacate"))
                "La Paz"->municipios.addAll(listOf("Seleccione una opcion","Cuyultitán","El Rosario (Rosario de La Paz)","Jerusalén","Mercedes La Ceiba","Olocuilta","Paraíso de Osorio",
                    "San Antonio Masahuat","San Emigdio","San Francisco Chinameca","San Juan Nonualco","San Juan Talpa","San Juan Tepezontes",
                    "San Luis La Herradura","San Luis Talpa","San Miguel Tepezontes","San Pedro Masahuat","San Pedro Nonualco","San Rafael Obrajuelo",
                    "Santa María Ostuma","Santiago Nonualco","Tapalhuaca","Zacatecoluca"))
                "La Libertad"->municipios.addAll(listOf("Seleccione una opcion","Antiguo Cuscatlán","Chiltiupán","Ciudad Arce","Colón","Comasagua","Huizúcar","Jayaque","Jicalapa",
                    "La Libertad","Santa Tecla (Nueva San Salvador)","Nuevo Cuscatlán","San Juan Opico","Quezaltepeque","Sacacoyo",
                    "San José Villanueva","San Matías","San Pablo Tacachico","Talnique","Tamanique","Teotepeque","Tepecoyo","Zaragoza"))
                "San Miguel"->municipios.addAll(listOf("Seleccione una opcion","Carolina","Chapeltique","Chinameca","Chirilagua","Ciudad Barrios","Comacarán","El Tránsito","Lolotique",
                    "Moncagua","Nueva Guadalupe","Nuevo Edén de San Juan","Quelepa","San Antonio del Mosco","San Gerardo","San Jorge",
                    "San Luis de la Reina","San Miguel","San Rafael Oriente","Sesori","Uluazapa"))
                "Usulután"->municipios.addAll(listOf("Seleccione una opcion","Alegría","Berlín","California","Concepción Batres","El Triunfo","Ereguayquín","Estanzuelas","Jiquilisco",
                    "Jucuapa","Jucuarán","Mercedes Umaña","Nueva Granada","Ozatlán","Puerto El Triunfo","San Agustín","San Buenaventura",
                    "San Dionisio","San Francisco Javier","Santa Elena","Santa María","Santiago de María","Tecapán","Usulután"))
                "Cabañas"->municipios.addAll(listOf("Seleccione una opcion","Cinquera","Dolores (Villa Doleres)","Guacotecti","Ilobasco","Jutiapa","San Isidro",
                    "Sensuntepeque","Tejutepeque","Victoria"))
                "Santa Ana"->municipios.addAll(listOf("Seleccione una opcion","Candelaria de la Frontera","Chalchuapa","Coatepeque","El Congo","El Porvenir","Masahuat","Metapán",
                    "San Antonio Pajonal","San Sebastián Salitrillo","Santa Ana","Santa Rosa Guachipilín","Santiago de la Frontera","Texistepeque"))
                "San Vicente"->municipios.addAll(listOf("Seleccione una opcion","Apastepeque","Guadalupe","San Cayetano Istepeque","San Esteban Catarina","San Ildefonso","San Lorenzo",
                    "San Sebastián","San Vicente","Santa Clara","Santo Domingo","Tecoluca","Tepetitán","Verapaz"))
                "La Unión"->municipios.addAll(listOf("Seleccione una opcion","Anamorós","Bolívar","Concepción de Oriente","Conchagua","El Carmen","El Sauce","Intipucá","La Unión","Lilisque",
                    "Meanguera del Golfo","Nueva Esparta","Pasaquina","Polorós","San Alejo","San José","Santa Rosa de Lima","Yayantique","Yucuaiquín"))
                "Morazán"->municipios.addAll(listOf("Seleccione una opcion","Arambala","Cacaopera","Chilanga","Corinto","Delicias de Concepción","El Divisadero","El Rosario","Gualococti",
                    "Guatajiagua","Joateca","Jocoaitique","Jocoro","Lolotiquillo","Meanguera","Osicala","Perquín","San Carlos","San Fernando",
                    "San Francisco Gotera","San Isidro","San Simón","Sensembra","Sociedad","Torola","Yamabal","Yoloaiquín"))
                "Cuscatlán"->municipios.addAll(listOf("Seleccione una opcion","Candelaria","Cojutepeque","El Carmen","El Rosario","Monte San Juan","Oratorio de Concepción","San Bartolomé Perulapía",
                    "San Cristóbal","San José Guayabal","San Pedro Perulapán","San Rafael Cedros","San Ramón","Santa Cruz Analquito","Santa Cruz Michapa",
                    "Suchitoto","Tenancingo"))
                "Ahuachapán"->municipios.addAll(listOf("Seleccione una opcion","Ahuachapán","Apaneca","Atiquizaya","Concepción de Ataco","El Refugio","Guaymango","Jujutla",
                    "San Francisco Menéndez","San Lorenzo","San Pedro Puxtla","Tacuba","Turín"))
            }
            return municipios
        }

        //Esta parte simula el evento ItemChange de una lista
        sp_Departamento?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //Codigo para cargar el otro spinner
                var depart:String=sp_Departamento.selectedItem.toString()
                val adaptadorMuni = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, getMunicipios(depart))
                sp_Municipio.adapter=adaptadorMuni
            }
        }

    }

    fun Guardar(Vista:View){
       if(et_Nombre.text.toString().equals("") || et_Apellido.text.toString().equals("") || et_Telefono.text.toString().equals("")
           || (rbFemenino.isChecked == false && rbMasculino.isChecked == false) || sp_Departamento.selectedItem.toString().equals("Seleccione una opcion") ||
           sp_Municipio.selectedItem.toString().equals("Seleccione una opcion")){
           Toast.makeText(this,"Complete todos los campos para continuar ", Toast.LENGTH_LONG).show()
       }else{
           Datos.clear()
           Datos.add(et_Nombre.text.toString())
           Datos.add(et_Apellido.text.toString())
           Datos.add(sp_Departamento.selectedItem.toString())
           Datos.add(sp_Municipio.selectedItem.toString())
           if(rbFemenino.isChecked){
               Datos.add("Femenino")
           }else if(rbMasculino.isChecked){
               Datos.add("Masculino")
           }
           Datos.add(et_Telefono.text.toString())
       }
    }
    fun Mostrar(Vista: View){
        if (Datos.size == 0){
            Toast.makeText(this,"No hay datos para mostrar ", Toast.LENGTH_LONG).show()
        }else {
            tvDatos.setText(
                "Nombre: " + Datos[0] + "\n" +
                        "Apellido: " + Datos[1] + "\n" +
                        "Departamento: " + Datos[2] + "\n" +
                        "Municipio: " + Datos[3] + "\n" +
                        "Sexo: " + Datos[4] + "\n" +
                        "Telefono: " + Datos[5] + "\n"
            )
        }
    }
}
package com.example.kisan_mitra.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.kisan_mitra.ui.theme.cantoraone

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Profile(modifier: Modifier=Modifier) {

    var name by remember { mutableStateOf("Mohit Lengure") }
    var email by remember { mutableStateOf("mohitlengure@gmail.com") }
    var phone by remember { mutableStateOf("7387784164") }
    var isEditing by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF7F7F7)),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "User Profile", fontFamily = cantoraone, color = Color.Black)

        Spacer(modifier = Modifier.height(20.dp))

        if (isEditing) {
            ProfileTextField("Name", name) { name = it }
            ProfileTextField("Email", email, KeyboardType.Email) { email = it }
            ProfileTextField("Phone", phone, KeyboardType.Phone) { phone = it }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { isEditing = false },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors()

            ) {
                Text("Save", color = Color.White)
            }
        } else {
            ProfileInfo("Name", name)
            ProfileInfo("Email", email)
            ProfileInfo("Phone", phone)

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { isEditing = true },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Edit Profile", color = Color.White)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTextField(label: String, value: String, keyboardType: KeyboardType = KeyboardType.Text, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color(0xFF11BD28)
        )
    )
}

@Composable
fun ProfileInfo(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, fontSize = 16.sp)
        Text(text = value, fontSize = 16.sp, textAlign = TextAlign.End)
    }
}
import React, { useState } from 'react';
import { View, TextInput, Button, Alert, StyleSheet } from 'react-native';
import axios from 'axios';

export default function Login({ navigation }) {
  const [email, setEmail] = useState("");
  const [motPasse, setMotPasse] = useState("");

  const handleLogin = () => {
    axios.post('http://10.0.2.2:8080/api/users/login', { email, motPasse })
      .then(response => {
        if (response.data) {
          navigation.replace('Accueil', { userId: response.data.id });
        } else {
          Alert.alert('Erreur', 'Email ou mot de passe incorrect');
        }
      })
      .catch(() => Alert.alert('Erreur', 'Connexion impossible'));
  };

  return (
    <View style={styles.container}>
      <TextInput 
        placeholder="Email" 
        value={email} 
        onChangeText={setEmail} 
        style={styles.input} 
      />
      <TextInput 
        placeholder="Mot de passe" 
        value={motPasse} 
        onChangeText={setMotPasse} 
        secureTextEntry={true} 
        style={styles.input} 
      />
      <Button title="Se connecter" color="#B22222" onPress={handleLogin} />
      <Button title="S'inscrire" color="#228B22" onPress={() => navigation.navigate('Inscription')} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1, justifyContent: 'center', backgroundColor: '#FDF5E6' },
  input: { borderWidth: 1, borderColor: '#B22222', padding: 10, marginBottom: 10, borderRadius: 8, backgroundColor: '#fff' }
});

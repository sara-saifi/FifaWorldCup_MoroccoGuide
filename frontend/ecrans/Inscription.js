import React, { useState } from 'react';
import { View, TextInput, Button, Alert, StyleSheet } from 'react-native';
import axios from 'axios';

export default function Inscription({ navigation }) {
  const [nom, setNom] = useState('');
  const [prenom, setPrenom] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleRegister = () => {
    axios.post('http://10.0.2.2:8080/api/users/register', {
      nom_utilisateur: nom,
      prenom_utilisateur: prenom,
      email,
      motPasse: password
    })
    .then(() => {
      Alert.alert('Succès', 'Inscription réussie');
      navigation.goBack();
    })
    .catch(() => Alert.alert('Erreur', 'Impossible de s’inscrire'));
  };

  return (
    <View style={styles.container}>
      <TextInput placeholder="Nom" value={nom} onChangeText={setNom} style={styles.input} />
      <TextInput placeholder="Prénom" value={prenom} onChangeText={setPrenom} style={styles.input}  />
      <TextInput placeholder="Email" value={email} onChangeText={setEmail} style={styles.input}  />
      <TextInput placeholder="Mot de passe" value={password} onChangeText={setPassword} secureTextEntry={true} style={styles.input} />
      <Button title="S'inscrire" color="#B22222" onPress={handleRegister} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 20, flex: 1, justifyContent: 'center', backgroundColor: '#FDF5E6' },
  input: { borderWidth: 1, borderColor: '#B22222', padding: 10, marginBottom: 10, borderRadius: 8, backgroundColor: '#fff' }
});

import React from 'react';
import { View, TouchableOpacity, Text, StyleSheet } from 'react-native';

export default function Accueil({ navigation, route }) {
  const { userId } = route.params;

  return (
    <View style={styles.container}>
      <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Restaurant', { userId })}>
        <Text style={styles.buttonText}>Restaurants</Text>
      </TouchableOpacity>
      <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Hotel', { userId })}>
        <Text style={styles.buttonText}>Hotels</Text>
      </TouchableOpacity>
      <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Matchs', { userId })}>
        <Text style={styles.buttonText}>Matchs</Text>
      </TouchableOpacity>
      <TouchableOpacity style={styles.button} onPress={() => navigation.navigate('Profile', { userId })}>
        <Text style={styles.buttonText}>Mes Réservations</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#FDF5E6' },
  button: { backgroundColor: '#B22222', padding: 15, margin: 10, borderRadius: 12, width: '80%', alignItems: 'center' },
  buttonText: { color: '#fff', fontSize: 18, fontWeight: 'bold' }
});

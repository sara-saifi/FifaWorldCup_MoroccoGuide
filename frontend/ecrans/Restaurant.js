import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, TouchableOpacity, StyleSheet, ActivityIndicator } from 'react-native';
import axios from 'axios';

export default function Restaurant({ navigation, route }) {
  const { userId } = route.params;
  const [restaurants, setRestaurants] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    axios.get('http://10.0.2.2:8080/api/restaurants')
      .then(res => {
        setRestaurants(res.data);
        setLoading(false);
      })
      .catch(err => {
        console.log(err);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return <ActivityIndicator size="large" color="#B22222" style={{ marginTop: 50 }} />;
  }

  return (
    <View style={styles.container}>
      <FlatList
        data={restaurants}
        keyExtractor={item => item.id_restaurant.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text style={styles.title}>{item.nom_restaurant}</Text>
            <Text style={styles.text}>Adresse: {item.adresse_restaurant}</Text>
            <Text style={styles.text}>Ville: {item.nomVille}</Text>
            <TouchableOpacity
              style={styles.button}
              onPress={() => navigation.navigate('Reservation', { userId, restaurantId: item.id_restaurant })}
            >
              <Text style={styles.buttonText}>Réserver</Text>
            </TouchableOpacity>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 15, backgroundColor: '#FDF5E6', flex: 1 },
  card: { borderWidth: 1, borderColor: '#B22222', padding: 15, marginBottom: 15, borderRadius: 12,
     backgroundColor: '#fff', shadowColor: '#000', shadowOpacity: 0.2, shadowRadius: 6 },
  title: { fontSize: 18, fontWeight: 'bold', color: '#B22222', marginBottom: 5 },
  text: { fontSize: 15, marginBottom: 5 },
  button: { marginTop: 10, backgroundColor: '#228B22', padding: 12, borderRadius: 10, alignItems: 'center' },
  buttonText: { color: '#fff', fontWeight: 'bold', fontSize: 16 }
});

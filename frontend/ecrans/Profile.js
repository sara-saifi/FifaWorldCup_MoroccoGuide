import React, { useEffect, useState } from 'react';
import { View, Text, FlatList, StyleSheet } from 'react-native';
import axios from 'axios';

export default function Profile({ route }) {
  const { userId } = route.params;
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    axios.get(`http://10.0.2.2:8080/api/reservations/user/${userId}`)
      .then(res => setReservations(res.data))
      .catch(err => console.log(err));
  }, []);

  return (
    <View style={styles.container}>
      <FlatList
        data={reservations}
        keyExtractor={item => item.id_reservation.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Text style={styles.text}>Restaurant: {item.restaurant?.nom_restaurant || "N/A"}</Text>
            <Text style={styles.text}>Hotel: {item.hotel?.nom_hotel || "N/A"}</Text>
            <Text style={styles.text}>Match: {item.match?.equipe1 || "N/A"}</Text>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { padding: 15, backgroundColor: '#FDF5E6', flex: 1 },
  card: { borderWidth: 1, borderColor: '#B22222', padding: 15, marginBottom: 15, borderRadius: 12, backgroundColor: '#fff', shadowColor: '#000', shadowOpacity: 0.2, shadowRadius: 6 },
  text: { fontSize: 15, color: '#333', marginBottom: 5 }
});

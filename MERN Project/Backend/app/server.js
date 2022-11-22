const express = require('express');
const mongoose = require('mongoose');

mongoose.connect('mongodb+srv://kkruthika:neuwebdeskk@cluster0.ky8qozg.mongodb.net/test', { useNewUrlParser: true });
const database = mongoose.connection;

database.on('error', (error) => {
    console.log(error)
})

database.once('connected', () => {
    console.log('Database Connected');
})
const app = express();
app.use(express.json());

const routes = require('./routes');

app.use('/user', routes)

app.listen(3001, () => {
    console.log(`Server Started at ${3001}`)
})
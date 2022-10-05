const express = require('express');
const cors = require('cors');
const app = express();
const { Users } = require('./models');

app.use(express.json());

app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods", 'GET,PUT,POST,DELETE');
    app.use(cors());
    next();
});

app.post('/conta/cadastrar', async (req, res) => {
    try {
        const userBody = req.body;
        const user = await Users.create({
            name: userBody.name,
            lastName: userBody.lastName,
            email: userBody.email,
            psw: userBody.psw
        });

        res.status(201).send( res.statusCode + JSON.stringify(user) + " Conta cadastrada");
    } catch (error) {
        res.status(500).send('Deu errado ' + error);
    }
});

app.listen(8000, () => {
    console.log('Servidor conectado');
});
const express = require('express');
const app = express();
const PORT = 3000;

app.use(express.static('public'));

app.get('/', (req, res) => {
    res.send('Hello Express!');
});

app.get('/about', (req, res) => {
    res.send('About....!');
});

app.listen(PORT, () => console.log(`Server listening on port: ${PORT}`));
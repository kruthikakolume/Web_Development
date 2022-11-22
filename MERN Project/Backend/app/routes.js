const express = require('express');
const Model = require('./models/test');
const router = express.Router();

router.post('/create', function (req, res) {
    try {
        const data = new Model({
            name: req.body.name,
            email: req.body.email,
            password: req.body.password
        })
        data.save().then(dataToSave => res.status(200).json(dataToSave))
    }
    catch (error) {
        res.status(400).json({ message: error.message })
    }
})

router.get('/getAll', function (req, res) {
    try {
        Model.find().then(data => res.json(data))
    }
    catch (error) {
        res.status(500).json({ message: error.message })
    }
})

router.put('/edit/:email', function (req, res) {
    try {
        const mail = req.params.email;
        const name = req.body.name;
        let pw = req.body.password;
        const email = req.body.email;
        Model.findOne({ email: req.params.email }).then(
            user => {
                if (user) {
                    if (mail !== email) {
                        res.send(`Email cannot be changed..`)
                    } else {
                        bcrypt.hash(pw, 10, function (hashError, hash) {
                            Model.findOneAndUpdate(
                                { email: mail }, { name: name, password: hash }, { new: true }
                            ).then(result => res.send(result))

                        });
                    }
                } else {
                    res.send(`Data does not exist..`)
                }
            }
        )

    }
    catch (error) {
        res.status(500).json({ message: error.message })
    }
})

router.delete('/delete/:email', function (req, res) {
    try {
        const mail = req.params.email;
        Model.findOne({ email: req.params.email }).then(
            user => {
                if (user) {
                    Model.findOneAndDelete({ email: mail }).then(data => res.send(`Document with ${data.name} has been deleted..`))
                } else {
                    res.send(`Data does not exist..`)
                }
            }
        )
    }
    catch (error) {
        res.status(400).json({ message: error.message })
    }
})

router.get('/get/:email', function (req, res) {
    try {
        Model.findOne({ email: req.params.email }).then(
            user => {
                if (user) {
                    res.json(user)
                } else {
                    res.send({})
                }

            }
        )
    }
    catch (error) {
        res.status(500).json({ message: error.message })
    }
})

module.exports = router;
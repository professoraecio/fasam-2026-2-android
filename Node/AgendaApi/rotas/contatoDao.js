const express = require('express');
const router = express.Router();
const url = require('url');
const queryString = require('querystring');
const mysql = require('./mysql').pool;

// http://localhost:3000/api.agenda/contato-dao/create
/*
{
    "nome" : "Joao",
    "fone" : "(99)99999-9999",
    "email" : "joao@gmail.com"
}
*/
router.post('/create',(req,res,next) => {

    const { nome , fone , email} = req.body;
    const contato = { nome , fone , email};

    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                'Erro:' : error,
                response : null
            });
        }
        conn.query(
            'INSERT INTO contato (nome , fone , email) VALUES (?,?,?)',
            [contato.nome, contato.fone , contato.email],
            (error,resultado,fields) => {
                conn.release();
                if (error) {
                    return res.status(500).send({
                        'Erro:': error,
                        response: null
                    });
                }
                res.status(201).send({
                    response : 'Contato cadastrado com sucesso!',
                    id_contato : resultado.insertId
                });
            }
        )
    });

});

// http://localhost:3000/api.agenda/contato-dao/getId?id=1
router.get('/getId',(req,res,next) => {
    
    const reqUrl = url.parse(req.url);
    const queryParams = queryString.parse(reqUrl.query);
    const id_contato = queryParams.id;

    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                'Erro:' : error,
                response : null
            });
        }
        conn.query(
            'SELECT * FROM contato WHERE id = ?',
            [id_contato],
            (error,resultado,fields) => {
                conn.release();
                if (error) {
                    return res.status(500).send({
                        'Erro:': error,
                        response: null
                    });
                }
                return res.status(200).send({
                    response : resultado
                });
            }
        )
    });

});

// http://localhost:3000/api.agenda/contato-dao/getAll
router.get('/getAll',(req,res,next) => {

    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                'Erro:' : error,
                response : null
            });
        }
        conn.query(
            'SELECT * FROM contato;',
            (error,resultado,fields) => {
                conn.release();
                if (error) {
                    return res.status(500).send({
                        'Erro:': error,
                        response: null
                    });
                }
                return res.status(200).send({
                    response : resultado
                });
            }
        )
    });

});

// http://localhost:3000/api.agenda/contato-dao/updateId
/*
{
    "id_contato" : 1,
    "nome" : "Joao",
    "fone" : "(99)99999-9900",
    "email" : "joao@gmail.com"
}
*/
router.post('/updateId',(req,res,next) => {

    const { id_contato , nome , fone , email} = req.body;
    const contato = { id_contato , nome , fone , email};

    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                'Erro:' : error,
                response : null
            });
        }
        conn.query(
            'UPDATE contato SET nome=? , fone=? , email=? WHERE id=?',
            [contato.nome, contato.fone , contato.email , contato.id_contato],
            (error,resultado,fields) => {
                conn.release();
                if (error) {
                    return res.status(500).send({
                        'Erro:': error,
                        response: null
                    });
                }
                res.status(201).send({
                    response : 'Contato atualizado com sucesso!'
                });
            }
        )
    });
});

// http://localhost:3000/api.agenda/contato-dao/deleteId
/*
{
    "id_contato" : 1
}
*/
router.post('/deleteId',(req,res,next) => {

    const { id_contato } = req.body;
    const contato = { id_contato };

    mysql.getConnection((error,conn) => {
        if(error){
            return res.status(500).send({
                'Erro:' : error,
                response : null
            });
        }
        conn.query(
            'DELETE FROM contato WHERE id=?',
            [ contato.id_contato],
            (error,resultado,fields) => {
                conn.release();
                if (error) {
                    return res.status(500).send({
                        'Erro:': error,
                        response: null
                    });
                }
                res.status(201).send({
                    response : 'Contato excluído com sucesso!'
                });
            }
        )
    });
});

module.exports = router;
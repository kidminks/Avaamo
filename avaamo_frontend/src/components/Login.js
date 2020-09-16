import React, {useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';
import {TextField, TextareaAutosize, Button, Select, MenuItem} from '@material-ui/core';
import {BASE_URL, TOPICS_URL, USERS} from "../utils/fetch";
import {notification} from "antd";

const getModalStyle = () => {
    const top = 40;
    const left = 50;

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}

const useStyles = makeStyles((theme) => ({
    paper: {
        position: 'absolute',
        width: 600,
        backgroundColor: theme.palette.background.paper,
        border: '2px solid #000',
        boxShadow: theme.shadows[5],
        padding: theme.spacing(2, 4, 3),
    },
}));

const Login = ({showModal, setShowModal}) => {
    const classes = useStyles();
    const [modalStyle] = React.useState(getModalStyle);
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [isLogin, setIsLogin] = useState(true);

    const getInit = () => {
        if (!isLogin) {
            return {
                method: 'post',
                body: JSON.stringify({
                    name: name,
                    password: password,
                }),
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }
        }else {
            return {
                method: 'get',
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }
        }
    }

    const submitUser = () => {
        fetch(`${BASE_URL}${USERS}${isLogin ? `?name=${name}&password=${password}`:''}`, getInit())
            .then(res => res.json())
            .then(res => {
                if (!res.id) {
                    notification.error({
                        message: 'Error'
                    })
                }else {
                    localStorage.setItem('user_name', res.name);
                    localStorage.setItem('id', res.id);
                    window.location.reload(false);
                }
            })
    }

    const body = (
        <div style={modalStyle} className={classes.paper}>
            <h2 id="simple-modal-title">{isLogin ? 'Login' : 'Register'}</h2>
            <div>
                <TextField id="standard-basic" label="Name" style={{width: '100%', marginBottom: '1em'}}
                           onChange={(e) => {
                               setName(e.target.value)
                           }}/>
            </div>
            <div>
                <TextField id="standard-basic" label="Password" style={{width: '100%', marginBottom: '1em'}}
                           type="password"
                           onChange={(e) => {
                               setPassword(e.target.value)
                           }}/>
            </div>
            <div style={{width: '100%', display: 'flex', justifyContent: 'center', marginTop: '1em'}}>
                <Button variant="contained" disabled={!name || name == "" || !password || password == ""}
                        onClick={() => {
                            submitUser()
                        }}>Submit</Button>
                <Button color="primary"
                        style={{marginLeft: '1em'}}
                        onClick={() => {
                            setIsLogin(!isLogin)
                        }}>{isLogin ? 'Register' : 'Login'}</Button>
            </div>
        </div>
    );

    return (
        <div>
            <Modal
                open={showModal}
                onClose={() => {
                    setShowModal(false)
                }}
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
            >
                {body}
            </Modal>
        </div>
    );
}

export default Login;

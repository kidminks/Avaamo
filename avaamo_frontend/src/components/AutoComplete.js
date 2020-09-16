import React, {useEffect, useState} from 'react';
import TextField from '@material-ui/core/TextField';
import Autocomplete from '@material-ui/lab/Autocomplete';
import {BASE_URL, TOPICS_URL} from '../utils/fetch';
import {notification} from "antd";

const Complete = ({onChange}) => {
    const [options, setOptions] = useState([]);

    useEffect(() => {
        fetch(`${BASE_URL}${TOPICS_URL}/all-subjects`)
            .then(res => res.json())
            .then(res => {
                setOptions(res);
            })
            .catch(e => {
                notification.error({
                    message: 'Error in fetching subjects',
                    description: e
                })
            })
    }, [])

    return (
        <Autocomplete
            id="topics"
            options={options}
            getOptionLabel={(option) => option[1]}
            style={{width: 1000}}
            renderInput={(params) => <TextField {...params} label="Search Topics" variant="outlined"/>}
            onChange={(event, newValue) => {
                onChange(newValue)
            }}
        />
    );
};

export default Complete;
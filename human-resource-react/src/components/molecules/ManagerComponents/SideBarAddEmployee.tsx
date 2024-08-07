import React, {useState, FormEvent, useEffect} from 'react';
import {TextField, Button, Box, Grid, InputLabel, Select, MenuItem, FormControl, Avatar} from '@mui/material';
import {HumanResources, useAppSelector} from "../../../store";
import {IUser} from "../../../models/IUser";
import {
    fetchAddEmployeeToManager,
    fetchFindCompanyNameAndManagerNameOfUser,
    fetchFindUserByToken, fetchGetEmployeeTypes,
    fetchGetPositions, fetchUpdateUser
} from "../../../store/feature/authSlice";
import {useDispatch} from "react-redux";

import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import dayjs from "dayjs";
import sweetalert2 from "sweetalert2";
import Swal from "sweetalert2";




const SideBarAddEmployee: React.FC = () => {


    const token = useAppSelector((state) => state.auth.token);
    const dispatch = useDispatch<HumanResources>();
    const [name, setName] = useState<string>( '');
    const [surname, setSurname] = useState<string>( '');
    const [email, setEmail] = useState<string>( '');
    const [phone, setPhone] = useState<string>( '');
    const [title, setTitle] = useState<string>( '');
    const [birthDate, setBirthDate] = useState<Date | null>(null);
    const [photo, setPhoto] = useState<string>('');
    const [hireDate, setHireDate] = useState<Date | null>(null);
    const [location, setLocation] = useState<string>('') ;

    const [positions, setPositions] = useState([]);
    const [selectedPositions, setSelectedPositions] = useState<string>('');

    const [employeeTypes, setEmployeeTypes] = useState([]);
    const [selectedEmployeeType, setSelectedEmployeeType] = useState<string>('');


    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        // Handle form submission
        console.log('Form submitted:', );
    };

    const setUserInfos = async () => {
        try {

            dispatch(fetchGetPositions())
                .then(data => {
                    console.log('Positions Response:', data);  // Log the response
                    setPositions(data.payload);
                })
                .catch(error => {
                    console.error('Error fetching positions:', error);  // Handle fetch errors
                });

            dispatch(fetchGetEmployeeTypes())
                .then(data => {
                    console.log('Positions Response:', data);  // Log the response
                    setEmployeeTypes(data.payload);
                })
                .catch(error => {
                    console.error('Error fetching positions:', error);  // Handle fetch errors
                });

        } catch (error) {
            console.error('Error in handleLogin:', error);  // Handle other errors
        }
    };

    useEffect(() => {
        setUserInfos();
    },[])

    console.log(name, surname, phone, title, birthDate, selectedPositions, location);
    const addEmployee = () => {

        if (!name || !surname    || !surname  || !phone || !title  || !birthDate  || !selectedEmployeeType || !location || !hireDate || !selectedPositions) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Please fill all the fields!',
            });
            return;
        }
        dispatch(fetchAddEmployeeToManager({
            token: token,
            name: name,
            surname: surname,
            phone: phone,
            title: title,
            birthDate: birthDate,
            ePosition: selectedPositions,
            location: location,
            hireDate: hireDate,
            eEmployeeType: selectedEmployeeType,
            email: email
        })).then((data) => {
            if (data.payload) {
                sweetalert2.fire({
                    icon: 'success',
                    title: 'Your profile has been updated successfully',
                    showConfirmButton: false,
                    timer: 1500
                })
            }else{
                sweetalert2.fire({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong!',
                    showConfirmButton: true
                })
            }
        })
    }

    return (


        <Grid container spacing={2}>
            <Grid item xs ={12}>
                <Box
                    component="form"
                    onSubmit={handleSubmit}
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        maxWidth: 800,
                        margin: 'auto',
                        alignItems: 'center',
                    }}
                >
                    <Avatar
                        alt="Remy Sharp"
                        src={photo}
                        sx={{ width: 150, height: 150 }}
                    />
                </Box>

            </Grid>
            <Grid item xs={6}>
                <Box
                    component="form"
                    onSubmit={handleSubmit}
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        gap: 2,
                        maxWidth: 800,
                        margin: 'auto',
                        padding: 2,
                    }}
                >

                    <TextField
                        label='Name'
                        name="name"
                        value={name}
                        onChange={event => setName(event.target.value)}
                        fullWidth
                        required
                    />
                    <TextField
                        label='Surname'
                        name="surname"
                        value={surname}
                        onChange={event => setSurname(event.target.value)}
                        fullWidth
                        required
                    />
                    <TextField
                        label='E-mail'
                        name="email"
                        value={email}
                        onChange={event => setEmail(event.target.value)}
                        fullWidth
                        required
                    />
                    <TextField
                        label='Phone'
                        name="phone"
                        value={phone}
                        onChange={event => setPhone(event.target.value)}
                        fullWidth
                        required
                        type={"number"}
                    />

                    <TextField
                        label='Title'
                        name="title"
                        value={title}
                        onChange={event => setTitle(event.target.value)}
                        fullWidth
                        required
                    />
                    <TextField
                        label='Location'
                        name="location"
                        value={location}
                        onChange={event => setLocation(event.target.value)}
                        fullWidth
                        required
                    />





                    <Button onClick={addEmployee} sx={{mt: 5}} type="button" variant="contained" color="primary">
                        Add Employee
                    </Button>
                </Box>
            </Grid>
            <Grid item xs={6}>
                <Box
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        gap: 2,
                        maxWidth: 800,
                        margin: 'auto',
                        padding: 2,
                    }}
                >
                    <FormControl required variant="outlined">
                        <InputLabel>{'Please Select Your Position'}</InputLabel>
                        <Select
                            value={selectedPositions}
                            onChange={event => setSelectedPositions(event.target.value as string)}
                            label="Position"
                        >
                            {positions.map((position) => (
                                <MenuItem key={position} value={position}>
                                    {position}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>

                    <FormControl required variant="outlined">
                        <InputLabel>{'Please Select Employee Type'}</InputLabel>
                        <Select
                            value={selectedEmployeeType}
                            onChange={event => setSelectedEmployeeType(event.target.value as string)}
                            label="Employee Type"
                        >
                            {employeeTypes.map((employeeType) => (
                                <MenuItem key={employeeType} value={employeeType}>
                                    {employeeType}
                                </MenuItem>
                            ))}
                        </Select>
                    </FormControl>
                    <LocalizationProvider  dateAdapter={AdapterDayjs}>
                        <DatePicker
                            label="Hire Date"
                            value={birthDate ? dayjs(hireDate) : null}
                            onChange={(newValue) => setHireDate(newValue ? newValue.toDate() : null)}

                        />
                    </LocalizationProvider>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <DatePicker
                            label="Birth Date"
                            value={birthDate ? dayjs(birthDate) : null}

                            onChange={(newValue) => setBirthDate(newValue ? newValue.toDate() : null)}

                        />
                    </LocalizationProvider>



                </Box>
            </Grid>
        </Grid>







    );
};

export default SideBarAddEmployee;
import * as React from 'react';
import {useEffect, useState} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {DataGrid, GridColDef, GridRowSelectionModel} from '@mui/x-data-grid';
import {HumanResources, RootState, useAppSelector} from '../../store';
import {fetchDeleteHoliday, fetchHolidays} from '../../store/feature/holidaySlice';
import {IHoliday} from '../../models/IHoliday';
import {Button, Grid, Box, Divider} from '@mui/material';
import HolidayFormSection from "../molecules/HolidayFormSection";

// Define the columns
const columns: GridColDef[] = [
    {field: 'id', headerName: 'ID', width: 70},
    {field: 'holidayName', headerName: 'Holiday', width: 130},
    {field: 'holidayType', headerName: 'Type', width: 160},
    {
        field: 'holidayStartDate',
        headerName: 'Start Date',
        width: 130,
    },
    {
        field: 'holidayEndDate',
        headerName: 'End Date',
        width: 130,
    },
];

export default function HolidayTable() {
    const holidays: IHoliday[] = useAppSelector((state: RootState) => state.holiday.holidayList);
    const dispatch = useDispatch<HumanResources>();
    const [selectedRowIds, setSelectedRowIds] = useState<number[]>([]);

    useEffect(() => {
        dispatch(fetchHolidays());
    }, [dispatch]);

    const handleRowSelection = (newSelectionModel: GridRowSelectionModel) => {
        setSelectedRowIds(newSelectionModel as number[]);
    };

    const handleConfirmSelection = () => {
        selectedRowIds.forEach((id) => {
            dispatch(fetchDeleteHoliday(id));
        });

        console.log('Selected Row IDs:', selectedRowIds);
    };

    return (
        <Box sx={{flexGrow: 1, padding: 2}}>
            <Grid container spacing={2}>
                <Grid item xs={12}>
                    <div style={{height: 400, width: '100%'}}>
                        <DataGrid
                            rows={holidays}
                            columns={columns}
                            initialState={{
                                pagination: {
                                    paginationModel: {page: 1, pageSize: 5},
                                },
                            }}
                            pageSizeOptions={[5, 10]}
                            checkboxSelection
                            onRowSelectionModelChange={handleRowSelection}
                            sx={{
                                '& .MuiDataGrid-columnHeaders': {
                                    backgroundColor: 'rgba(224, 224, 224, 1)',
                                },
                                '& .MuiDataGrid-columnHeaderTitle': {
                                    textAlign: 'center',
                                    fontWeight: 'bold',
                                },
                                '& .MuiDataGrid-cell': {
                                    textAlign: 'center',
                                },
                            }}
                        />
                        <Grid container spacing={2} style={{marginTop: 16}}>
                            <Grid item xs={12}>
                                <Button style={{marginRight: 4}}
                                        onClick={handleConfirmSelection}
                                        variant="contained"
                                        color="primary"
                                        disabled={true}
                                >
                                    Confirm Selection
                                </Button>
                                <Button
                                    onClick={handleConfirmSelection}
                                    variant="contained"
                                    color="error"
                                >
                                    Delete Selected
                                </Button>
                            </Grid>
                        </Grid>
                    </div>
                </Grid>
                <Grid item xs={12}>
                    <Divider sx={{my: 4}}/>
                </Grid>
                <Grid item xs={12}>
                    <HolidayFormSection/>
                </Grid>
            </Grid>
        </Box>
    );
}

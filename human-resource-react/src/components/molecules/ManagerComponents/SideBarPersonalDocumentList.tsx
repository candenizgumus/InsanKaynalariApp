import React, { useState, useEffect } from 'react';
import { TextField } from '@mui/material';
import { HumanResources, useAppSelector } from "../../../store";
import { useDispatch } from "react-redux";
import {
     fetchPersonalDocuments,
    } from "../../../store/feature/personalDocumentSlice";
import {DataGrid, GridColDef, GridRowSelectionModel} from "@mui/x-data-grid";
import DownloadButtonFromS3 from "../../atoms/DownloadButtonFromS3";
const columns: GridColDef[] = [

    {field: "id", headerName: "Id", width: 90, headerAlign: "center"},
    {field: "email", headerName: "Email", width: 120, headerAlign: "center"},
    {field: "description", headerName: "Description", width: 120, headerAlign: "center"},
    {field: "documentType", headerName: "Document Type", width: 120, headerAlign: "center"},
    {
        field: "attachedFile", headerName: "Document", headerAlign: "center", width: 100,
        renderCell: (params) => (
            <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', width: '100%', height: '100%' }}>
                {params.value && <DownloadButtonFromS3 fileKey={params.value}/> }
            </div>
        )
    },

];
const SideBarPersonalDocumentList: React.FC = () => {
    const [selectedRowIds, setSelectedRowIds] = useState<number[]>([]);
    const token = useAppSelector((state) => state.auth.token);
    const employeeId = useAppSelector((state) => state.auth.selectedEmployeeId);
    const dispatch = useDispatch<HumanResources>();
    const [personalDocuments , setPersonelDocuments] = useState([]);
    const [searchText, setSearchText] = useState('');


    useEffect( () => {
        dispatch(fetchPersonalDocuments({
            token: token,
            page:0,
            searchText: searchText,
            pageSize: 100,
        })).then(data => {
            setPersonelDocuments(data.payload);
        })

    }, [dispatch, token, searchText]);


    const handleRowSelection = (newSelectionModel: GridRowSelectionModel) => {
        setSelectedRowIds(newSelectionModel as number[]);
    };

    return (
        <div style={{height: 400, width: "inherit"}}>
            <TextField
                label="Email"
                variant="outlined"
                onChange={(event) => setSearchText(event.target.value)}
                value={searchText}
                style={{ marginBottom: "10px" }}
            />
            <DataGrid
                rows={personalDocuments}
                columns={columns}
                initialState={{
                    pagination: {
                        paginationModel: {page: 0, pageSize: 5},
                    },
                }}
                pageSizeOptions={[5, 10]}
                checkboxSelection
                onRowSelectionModelChange={handleRowSelection}
                sx={{
                    "& .MuiDataGrid-columnHeaders": {
                        backgroundColor: "rgba(224, 224, 224, 1)",
                    },
                    "& .MuiDataGrid-columnHeaderTitle": {
                        textAlign: "center",
                        fontWeight: "bold",
                    },
                    "& .MuiDataGrid-cell": {
                        textAlign: "center",
                    },
                    "& .approved-row": {
                        backgroundColor: "#e0f2e9", // Onaylananlar için yeşil arka plan
                    },
                    "& .unapproved-row": {
                        backgroundColor: "#ffe0e0", // Onaylanmayanlar için kırmızı arka plan
                    },
                }}
            />

        </div>


    );
};

export default SideBarPersonalDocumentList;
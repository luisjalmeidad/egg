import React, { useRef } from 'react'

export default function SelectUserType({ handleClick }) {
    const selectRef = useRef()
    return (
        <div className='select-container'>
            <div className='select-user'>
                <h3>Elegi tu rol</h3>
                <select ref={selectRef}>
                    <option value="">Elegi tu rol</option>
                    <option value="alumno">Alumno</option>
                    <option value="profesor">Profesor</option>
                </select>
                <button onClick={() => handleClick(selectRef)}>Continuar</button>
            </div>
        </div>
    )
}

import React from 'react'
import { useState } from 'react'
import FormAlumno from '../../components/FormAlumno'
import FormProfesor from '../../components/FormProfesor'
import SelectUserType from '../../components/SelectUserType'
import "./register.scss"

export default function Register() {

	const [choosedUser, setChoosedUser] = useState(false)
	const [userType, setUserType] = useState("")

	function handleChooseUserClick(select) {
		if(select.current.value){
			setUserType(select.current.value)
			setChoosedUser(true)
		}
		
	}

	return (
		<div className='register'>
			{
				!choosedUser ?
					<SelectUserType handleClick={handleChooseUserClick} />
					:
					<>
						{userType === "alumno" && <FormAlumno />}
						{userType === "profesor" && <FormProfesor />}
					</>

			}
		</div>
	)
}

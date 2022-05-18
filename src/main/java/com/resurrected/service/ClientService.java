package com.resurrected.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;


import com.resurrected.entity.Client;
import com.resurrected.entity.Photo;
import com.resurrected.enums.Rol;
import com.resurrected.enums.StatusClient;
import com.resurrected.error.ErrorService;
import com.resurrected.mapper.ClientMapper;
import com.resurrected.model.ClientRegisterModel;
import com.resurrected.repository.ClientRepository;




@Service
public class ClientService implements UserDetailsService {

	private final ClientRepository clientRepository;
	private final PhotoService photoService;
	private final EmailNotifications emailNotifications;

	public ClientService(ClientRepository clientRepository, PhotoService photoService, EmailNotifications emailNotifications) {
		this.clientRepository = clientRepository;
		this.photoService = photoService;
		this.emailNotifications = emailNotifications;
	}

	@Autowired
	private ClientMapper clientmapper;
	



	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Client createClient(ClientRegisterModel clientModel) throws ErrorService {
		
		Client client = clientmapper.toEntity(clientModel);

		emailNotifications.sendEmail("Gracias por registrarte a Resurrected", "Bienvenido", clientModel.getEmail());
		
		return clientRepository.save(client);

	}

	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public Client editClient(String idClient, MultipartFile file, String name, String lastname, Long document,
			String phoneNumber, String address, String email, String password1, String password2) throws ErrorService {

		checkDataEdit(email,idClient, password1, password2, document, phoneNumber);

		Optional<Client> check = clientRepository.findById(idClient);

		if (check != null) {

			Client client = check.get();
			client.setName(name);
			client.setLastname(lastname);
			client.setDocument(document);
			client.setPhoneNumber(phoneNumber);
			client.setAdress(address);
			client.setEmail(email);
			String encrypted = new BCryptPasswordEncoder().encode(password1);
			client.setPassword(encrypted);
			client.setUpdateDate(new Date());
			client.setActive(true);
			client.setStatusClient(StatusClient.Full);
			Photo photo = photoService.multiPartToEntity(file);
			client.setPhoto(photo);
			emailNotifications.sendEmail("El usuario fue actualizado satifactoriamente", "Usuario actualizado", email);
			return clientRepository.save(client);

		} else {

			throw new ErrorService("No existe el usuario en la base de datos");
		}

	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void removeClient(String idClient) {
		Optional<Client> check = clientRepository.findById(idClient);
		if (check != null) {
			Client client = check.get();
			clientRepository.delete(client);
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void active(String idClient) {
		Optional<Client> check = clientRepository.findById(idClient);
		if (check != null) {
			Client client = check.get();
			client.setActive(true);
			clientRepository.save(client);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void passive(String idClient) {
		Optional<Client> check = clientRepository.findById(idClient);
		if (check != null) {
			Client client = check.get();
			client.setActive(false);
			clientRepository.save(client);
		}
	}

	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Client> findTrue() {
		return clientRepository.findTrue();
	}

	@Transactional(readOnly = true)
	public List<Client> findFalse() {
		return clientRepository.findFalse();
	}

	@Transactional(readOnly = true)
	public Client findId(String idClient) {
		return clientRepository.findId(idClient);
	}

	@Transactional(readOnly = true)
	public Optional<Client> findIdOp(String idClient) {
		return clientRepository.findById(idClient);
	}

	@Transactional(readOnly = true)
	public Client findDni(Long document) {
		return clientRepository.findDni(document);
	}

	public void checkDataEdit(String email,String id, String password1, String password2, Long document, String phoneNumber)
			throws ErrorService {

		if (clientRepository.findDni(document) != null) {
			throw new ErrorService("El Dni que ingreso ya esta en uso, ingrese uno nuevo");
		}

		if (document == null || document <= 7) {
			throw new ErrorService("El documento no puede estar vacio o" + " contener menos de 8 caracteres numericos");
		}

		if (clientRepository.findPhoneNumber(phoneNumber) != null) {
			throw new ErrorService("El Telefono que ingreso ya esta en uso, ingrese uno nuevo");
		}
		if (clientRepository.findEmailAndID(email, id) != null) {
			throw new ErrorService("El email que ingreso ya esta en uso, ingrese uno nuevo");
		}
		if (password1.isEmpty() || password1 == null || password1.length() <= 7) {
			throw new ErrorService("La contraseña no puede esta vacia y  contener menos de 8 caracteres numericos");
		}
		if (password2.isEmpty() || password2 == null || password2.length() <= 7) {
			throw new ErrorService("La contraseña no puede esta vacia y  contener menos de 8 caracteres numericos");
		}

		if (!password1.equals(password2)) {
			throw new ErrorService("Las contraseñas deben ser iguales");
		}

	}

	public void checkDataBase(String name, String lastname, String email,
			String password1, String password2) throws ErrorService {


		if (clientRepository.findEmail(email) != null) {
			throw new ErrorService("El email que ingreso ya esta en uso, ingrese uno nuevo");
		}
//		if (clientRepository.findDni(document) != null) {
//			throw new ErrorService("El Dni que ingreso ya esta en uso, ingrese uno nuevo");
//		}
//
//		if (document == null || document <= 7) {
//			throw new ErrorService("El documento no puede estar vacio o" + " contener menos de 8 caracteres numericos");
//		}
//
//		if (clientRepository.findPhoneNumber(phoneNumber) != null) {
//			throw new ErrorService("El Telefono que ingreso ya esta en uso, ingrese uno nuevo");
//		}

		if (name.isEmpty() || name == null) {
			throw new ErrorService("El nombre no puede estar vacio o ser nulo");
		}
		if (lastname.isEmpty() || lastname == null) {
			throw new ErrorService("El apellido ni puede estar vacio o ser nulo");
		}
//		if (address.isEmpty() || address == null) {
//			throw new ErrorService("La direccion no puede estar vacia o estar nula");
//		}
//		if (phoneNumber.isEmpty() || phoneNumber == null) {
//			throw new ErrorService("El telefono no puede estar vacio o nulo");
//		}
		if (password1.isEmpty() || password1 == null || password1.length() <= 7) {
			throw new ErrorService("La contraseña no puede esta vacia y  contener menos de 8 caracteres numericos");
		}
		if (password2.isEmpty() || password2 == null || password2.length() <= 7) {
			throw new ErrorService("La contraseña no puede esta vacia y  contener menos de 8 caracteres numericos");
		}

		if (!password1.equals(password2)) {
			throw new ErrorService("Las contraseñas deben ser iguales");
		}

	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client client = clientRepository.findEmail(email);

		if (client != null) {
			List<GrantedAuthority> permits = new ArrayList<>();
			if (client.getRol().toString().equals("ADMIN")) {
				GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USER_" + Rol.ADMIN.toString());
				permits.add(p1);
			}

			if (client.getRol().toString().equals("CLIENT")) {
				GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_USER_" + Rol.CLIENT.toString());
				permits.add(p1);
			}
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpSession session = attr.getRequest().getSession(true);
			session.setAttribute("sessionuser", client);
			User user = new User(client.getEmail(), client.getPassword(), permits);			
			emailNotifications.sendEmail("Ud. ha iniciado sesion", "Inicio de Sesion", email);
			return user;
		}
		return null;
	}
}

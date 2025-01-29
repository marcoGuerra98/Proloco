package com.example.proloco.Service;

import com.example.proloco.Bean.Anagrafica;
import com.example.proloco.Model.User;
import com.example.proloco.Utils.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.example.proloco.Constant.Constant.*;


@Service
public class UserService {

    private List<User> listUser;

    private List<User> listFromDB;

    public UserService() throws ParseException, IOException {

        listUser = new ArrayList<>();

        /*
        Anagrafica anagrafica = new Anagrafica("lele", "adani", "DNALLE80A01E648Y","1/01/1980","viva el futbool", 10);
        User user = new User(1,anagrafica,"lele@gmail.com","12345");

        listUser.add(user);

        //anagrafica = new Anagrafica("antonio", "cassano", "CSSNTN80A01E648H","1/01/1980","viva el futbool", 99);
        user = new User(2,anagrafica,"anto@gmail.com","67890");

        listUser.add(user);
        //stampaUser(listFromDB);

         */


    }

    public User getUser(int id) {
        for (User user : listUser) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public void setUser(User user) {
        if (user != null) {
            int id = listUser.size() + 1;
            user.setId(id);
            listUser.add(user);
        }
    }

    public User getUserFromDB(int id) {
        listFromDB = getAllFromDB(filePath);
        for (User user : listFromDB) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public void stampaUser(List<User> list) {
        for (User user : list) {
            Anagrafica anagrafica = user.getAnagrafica();
            System.out.println(
                    "User ID: " + user.getId() +
                    ", nome: " + anagrafica.getNome() +
                    ", cognome: " + anagrafica.getCognome() +
                    ", codice fiscale: " + anagrafica.getCodiceFiscale() +
                    ", data nascita: " + anagrafica.getDataNascita() +
                    ", indirizzo: " + anagrafica.getIndirizzo() +
                    ", email: " + user.getEmail() +
                    ", numero cellulare: " + user.getNumeroCellulare());
        }
    }

    public List<User> getAllFromDB(String filePath) {

        List<User> listUser = new ArrayList<>();
        List<String[]> fromDB;
        try {
            fromDB = new ArrayList<>(ExcelUtils.readDataFromExcel(filePath));
        } catch (Exception e) {
            throw new RuntimeException("Errore specifico: " + e.getMessage(), e);
        }

        /*
        for (String[] array: fromDB) {
            System.out.println("Nuovo record:");
            for (String elemento : array) {
                System.out.println("  " + elemento);
            }
        }*/

        Anagrafica anagrafica;
        User user;

        for (String[] array: fromDB) {
            int i = 0;
            anagrafica = new Anagrafica();
            user = new User();
            for (String elemento : array) {
                if (elemento != null) {
                    if (i == ZERO) {
                        int numero = (int) Double.parseDouble(elemento);
                        user.setId(numero);
                        i++;
                    } else if (i == UNO){
                        anagrafica.setNome(elemento);
                        i++;
                    } else if (i == DUE){
                        anagrafica.setCognome(elemento);
                        i++;
                    } else if (i == TRE){
                        anagrafica.setSesso(elemento);
                        i++;
                    } else if (i == QUATTRO){
                        anagrafica.setCaricaSociale(elemento);
                        i++;
                    } else if (i == CINQUE){
                        anagrafica.setDataIscrizione(elemento);
                        i++;
                    } else if (i == SEI){
                        anagrafica.setCodiceFiscale(elemento);
                        i++;
                    } else if (i == SETTE){
                        anagrafica.setDataNascita(elemento);
                        i++;
                    } else if (i == OTTO){
                        anagrafica.setComuneNascita(elemento);
                        i++;
                    } else if (i == NOVE) {
                        anagrafica.setStatoEsteroNascita(elemento);
                        i++;
                    } else if (i == DIECI) {
                        anagrafica.setComuneEsteroNascita(elemento);
                        i++;
                    } else if (i == UNDICI) {
                        anagrafica.setComune(elemento);
                        i++;
                    } else if (i == DODICI) {
                        anagrafica.setIndirizzo(elemento);
                        i++;
                    } else if (i == TREDICI) {
                        anagrafica.setCap(elemento);
                        i++;
                    } else if (i == QUATTORDICI) {
                        user.setEmail(elemento);
                        i++;
                    } else if (i == QUINDICI) {
                        user.setNumeroCellulare(String.valueOf((int) Double.parseDouble(elemento)));
                        i++;
                    } else if (i == SEDICI) {
                        user.setStatoIscrizione(elemento);
                        i++;
                    }
                }

            }
            user.setAnagrafica(anagrafica);
            listUser.add(user);
        }
        return listUser;
    }

    public void insertUserIntoDB(User user) throws IOException, InvalidFormatException {
        // TODO: fare in modo che restituisca una risposta di ok o KO
        List<String[]> listToInsert = new ArrayList<>();
        List<User> listUser = new ArrayList<>();
        listUser.add(user);
        if (!listUser.isEmpty()) {
            String[] transformation;
            int ultimaRiga = ExcelUtils.lastRowFile(filePath);
            for (User i : listUser) {
                transformation = tranformUserIntoStringArray(i, ultimaRiga);
                listToInsert.add(transformation);
                ultimaRiga++;
            }
            //richiamare metodo di ExcelUtils
            ExcelUtils.writeDataToExcel(filePath, listToInsert);

        }
    }

    public String[] tranformUserIntoStringArray(User user, int id) {
        String[] arrayString = new String[9];

        if (user != null) {
            Anagrafica anagrafica = user.getAnagrafica();

            arrayString[ZERO] = String.valueOf(id);

            String nome = anagrafica.getNome();
            if (nome != null) {
                arrayString[UNO] = nome;
            }

            String cognome = anagrafica.getCognome();
            if (cognome != null) {
                arrayString[DUE] = cognome;
            }

            String codFiscale = anagrafica.getCodiceFiscale();
            if (codFiscale != null) {
                arrayString[TRE] = codFiscale;
            }

            String data = anagrafica.getDataNascita();
            if (data != null) {
                arrayString[QUATTRO] = data;
            }

            String indirizzo = anagrafica.getIndirizzo();
            if (indirizzo != null) {
                arrayString[CINQUE] = indirizzo;
            }

            /*
            int numerCivico = anagrafica.getNumeroCivico();
            arrayString[SEI] = String.valueOf(numerCivico);*/


            String email = user.getEmail();
            if (email != null) {
                arrayString[SETTE] = email;
            }

            String cell = user.getNumeroCellulare();
            if (cell != null) {
                arrayString[OTTO] = cell;
            }
        }

        return arrayString;

    }
}


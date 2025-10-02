{
Una clínica necesita un sistema para el procesamiento de las atenciones realizadas a los pacientes en julio de 2024. 
Implementar un módulo que lea información de las atenciones. 
De cada atención se lee matrícula del médico, DNI del paciente, día y diagnóstico (valor entre 1 y 6). 
La lectura finaliza con el DNI 0. Se sugiere utilizar el módulo leerAtencion(). El módulo deber retornar dos estructuras 

i. Un Árbol binario de búsqueda ordenado por matrícula del médico. 
Para cada matricule de médico debe almacenar la cantidad de atenciones realizadas. 

ii. Un vector que almacene en cada posición el tipo del género y la lista de los DNI de pacientes atendidos con ese diagnóstico.

b) Implementar un módulo que reciba el árbol generado en a), una matrícula y retorne la cantidad total de atenciones realizadas
por los médicos con matrícula superior  a la matrícula ingresada.

c) Realizar un módulo recursivo que reciba el vector generado en a) y retorne el diagnóstico con mayor cantidad de
pacientes atendidos.
}

program clinica;

const
    diagnosticos=6;
    dias=31;
    fin=0;

type
    rangoDiagnostico= 1..diagnosticos;
    rangoDias= 1..dias;

    atencion=record
        matricula:integer;
        dni:integer;
        dia:rangoDias;
        diagnostico:rangoDiagnostico;
    end;

    estructura=record
        matricula:integer;
        cantAtenciones:integer;
    end;

    arbol=^nodo;
    nodo=record
        elem:estructura;
        hi:arbol;
        hd:arbol;
    end;

    lista=^nodoLista;
    nodoLista=record
        elem:integer;
        sig:lista;
    end;

    vector= array[rangoDiagnostico] of lista;

    procedure leerAtencion(var a:atencion);
    begin
        a.dni:= random(9999);
        if a.dni <> fin then begin
            a.matricula:= random(9999);
            a.dia:= random(31)+1;
            a.diagnostico:= random(6)+1;
        end;
    end;

    procedure agregarArbol(var a:arbol; matricula:integer);
    begin
        if a=nil then begin
            new(a);
            a^.elem.matricula:= matricula;
            a^.elem.cantAtenciones:= 1;
            a^.hi:= nil;
            a^.hd:= nil;
        end
        else if (matricula < a^.elem.matricula) then agregarArbol(a^.hi, matricula)
        else if (matricula > a^.elem.matricula) then agregarArbol(a^.hd, matricula)
        else a^.elem.cantAtenciones:= a^.elem.cantAtenciones + 1;
    end;

    procedure inicializarVec(var v:vector);
    var i:integer;
    begin
        for i:=1 to diagnosticos do v[i]:= nil;
    end;

    procedure agregarAdelante(var l:lista; dni:integer);
    var nue:lista;
    begin
        new(nue);
        nue^.elem:= dni;
        nue^.sig:= l;
        l:= nue;
    end;

    procedure generarArbol(var a:arbol; var v:vector);
    var at:atencion;
    begin
        leerAtencion(at);
        if (at.dni <> fin) then begin
            agregarArbol(a,at.matricula);
            agregarAdelante(v[at.diagnostico], at.dni);
            generarArbol(a,v);
        end;
    end;

var 
    ar:arbol;
    v:vector;

begin
    ar:= nil;
    inicializarVec(v);
    generarArbol(ar,v);
end.

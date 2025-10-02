{
Un supermercado quiere llevar un registro de todas sus ventas, de cada venta se lee el codigo, 
dni del cliente, sucursal en la que compró (1..5) y monto gastado, la lectura se detiene 
con el código de venta 0, se pide:

A- crear una estructura eficiente para la busqueda por dni de cliente, de cada cliente 
se guarda el monto gastado en cada sucursal

B-un módulo que reciba la estructura generada en A y un número de sucursal y 
retorne la cantidad de clientes que no gastaron nada en la sucursal

C-un modulo que reciba la estructura generara en A y un dni y retorne el monto total 
general gastado por dicho dni (es decir, la suma de los montos de todas las sucursales)

}

program super;

const
    sucursales=5;
    fin=0;

type
    rangoSucursal=1..sucursales;

    vecMontoSucursal= array[rangoSucursal] of real;

    venta= record
        cod:integer;
        dni:integer;
        sucursal:rangoSucursal;
        monto:real;
    end;

    guardar=record
        dni:integer;
        montoSucursal:vecMontoSucursal;
    end;

    arbol= ^nodo;
    nodo= record
        elem:guardar;
        hi:arbol;
        hd:arbol
    end;

    procedure inicializarVec(var v:vecMontoSucursal);
    var i:integer;
    begin
        for i:=1 to sucursales do v[i]:= 0.0;
    end;

    procedure leerInfo(var v:venta);
    begin
        v.cod:= random(100);
        if v.cod <> 0 then begin
            v.dni:= random(9999);
            v.sucursal:= random(5) + 1; // rango 1..5
            v.monto:= random(300);
        end;
    end;

    procedure agregar(var a:arbol; v:venta);
    begin
        if (a = nil) then begin
            new(a);
            inicializarVec(a^.elem.montoSucursal);
            a^.elem.dni:= v.dni;
            a^.elem.montoSucursal[v.sucursal]:= v.monto;

            a^.hi:= nil;
            a^.hd:= nil;
        end

        else if v.dni < a^.elem.dni then agregar(a^.hi,v)
        else if v.dni > a^.elem.dni then agregar(a^.hd,v)
        else a^.elem.montoSucursal[v.sucursal]:= a^.elem.montoSucursal[v.sucursal] + v.monto;
    end;

    procedure cargar(var a:arbol);
    var v:venta;
    begin
        leerInfo(v);
        if (v.cod <> fin) then begin
            agregar(a,v);
            cargar(a);
        end;
    end;

    procedure imprimir(a:arbol);
    var i:integer;
    begin
        if (a <> nil) then begin
            imprimir(a^.hi);

            writeln('DNI del cliente: ', a^.elem.dni);
            write('Montos por sucursal: ');
            for i := 1 to sucursales do
            begin
                write('Sucursal ', i, ': ', a^.elem.montoSucursal[i]:0:2, '  '); 
            end;
            writeln;
            writeln('-----------------------------------');
            imprimir(a^.hd);
        end;
    end;

// B-un módulo que reciba la estructura generada en A y un número de sucursal y 
// retorne la cantidad de clientes que no gastaron nada en la sucursal

function cantClientes(a:arbol; num:rangoSucursal): integer;
begin
    if (a = nil) then cantClientes:= 0 
    else begin
        if (a^.elem.montoSucursal[num] = 0.0) then cantClientes:= 1
        else cantClientes:= 0;
        cantClientes:= cantClientes + cantClientes(a^.hi, num) + cantClientes(a^.hd, num);
    end;
end;

// C-un modulo que reciba la estructura generara en A y un dni y retorne el monto total 
// general gastado por dicho dni (es decir, la suma de los montos de todas las sucursales)

function dniMonto(a:arbol; dni:integer): real;
var i:integer;
begin
    if (a = nil) then dniMonto:= 0.0
    else if (dni < a^.elem.dni) then dniMonto:= dniMonto(a^.hi, dni)
    else if (dni > a^.elem.dni) then dniMonto:= dniMonto(a^.hd, dni)
    else begin
        dniMonto:= 0.0;
        for i:=1 to sucursales do dniMonto:= dniMonto + a^.elem.montoSucursal[i];
    end;
end;

var
    ar:arbol;

begin
    randomize;
    ar:=nil;
    cargar(ar);
    imprimir(ar);
    writeln(cantClientes(ar,5));
    writeln(dniMonto(ar,9872):0:2);
end.

CREATE OR REPLACE FUNCTION pure_db_logic(a int)
returns int
language plpgsql
as
$$
declare
   result integer;
begin
   select 42 into result;
   return result;
end;
$$;

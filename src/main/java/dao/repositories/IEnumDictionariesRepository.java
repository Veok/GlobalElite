package dao.repositories;

import domain.model.EnumDictionary;

import java.util.List;

/**
 * @author L on 17.11.2016.
 */
public interface IEnumDictionariesRepository extends IRepository<EnumDictionary> {

    public List<EnumDictionary> withDictionaryName(String enumName);

    public List<EnumDictionary> getEnumValues(String enumName, String stringKey);

    public List<EnumDictionary> getEnumValues(String enumName, int stringKey);
}

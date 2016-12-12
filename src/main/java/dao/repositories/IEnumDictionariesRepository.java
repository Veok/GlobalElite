package dao.repositories;

import domain.model.EnumDictionary;

import java.util.List;

/**
 * @author L on 17.11.2016.
 */
public interface IEnumDictionariesRepository extends IRepository<EnumDictionary> {

    List<EnumDictionary> withDictionaryName(String enumName);

    List<EnumDictionary> getEnumValues(String enumName, String stringKey);

    List<EnumDictionary> getEnumValues(String enumName, int stringKey);
}

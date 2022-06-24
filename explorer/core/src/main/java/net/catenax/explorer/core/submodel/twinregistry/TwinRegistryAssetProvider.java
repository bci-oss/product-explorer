package net.catenax.explorer.core.submodel.twinregistry;

import java.util.List;
import lombok.RequiredArgsConstructor;
import net.catenax.explorer.core.exception.ResourceNotFoundException;
import net.catenax.explorer.core.submodel.ShellDescriptorProvider;
import org.eclipse.dataspaceconnector.spi.types.domain.edr.EndpointDataReference;

@RequiredArgsConstructor
public class TwinRegistryAssetProvider implements ShellDescriptorProvider {

  private final TwinRegistryClient client;

  @Override
  public ShellDescriptorResponse search(String query, String endpointAddress) {
    final List<String> matchedSubmodelsIds = client.lookup(query, endpointAddress);
    if (matchedSubmodelsIds.isEmpty()) {
      throw new ResourceNotFoundException(query);
    }
    return client.fetchShellDescriptor(endpointAddress, matchedSubmodelsIds);
  }

  @Override
  public void persistCallback(EndpointDataReference endpointDataReference) {
  }
}